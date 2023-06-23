package com.example.controller.user;


import com.example.model.Chapter;
import com.example.model.Comic;
import com.example.model.DTO.ChapterDTO;
import com.example.model.DTO.ComicDTO;
import com.example.model.Order;
import com.example.model.User;
import com.example.repository.IChapter;
import com.example.service.*;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(
        value = {"/truyen-tranh/*"},
        initParams = {
                @WebInitParam(name = "comic", value = "^[a-zA-Z0-9_-]+$"),
                @WebInitParam(name = "chapterName", value = "^chap-(?:[1-9]|[1-9][0-9]{1,8}|100000000)$"),
                @WebInitParam(name = "chapterId", value = "[1-9]\\d*")
        }
)
public class ChapterServlet extends ComicServlet {
    private ComicService comicService= new ComicService();
    private ChapterService chapterService=new ChapterService();
    private OrderService orderService=new OrderService();
    private UserService userService=new UserService();
    private PageService pageService=new PageService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String comicRegex = getServletConfig().getInitParameter("comic");
        String chapterNameRegex = getServletConfig().getInitParameter("chapterName");
        String chapterIdRegex = getServletConfig().getInitParameter("chapterId");
        String pathInfo = request.getPathInfo();
        String[] parts = pathInfo.split("/");

        if(parts.length==2){
            super.doGet(request,response);
        }
        else if(parts.length==4){
            int idComic=Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
            String chapterName=parts[2];
            int chapterId = Integer.parseInt(parts[3]);
            showPageByChapter(request,response,chapterId,idComic);
        }
        else {

        }
    }
    private void showPageByChapter(HttpServletRequest request, HttpServletResponse response,int chapterId,int idComic) throws IOException, ServletException {
        try {
            Chapter chapter=chapterService.selectChapter(chapterId);
            if(chapter.getLock()==1){
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                if(user==null){
                    session.setAttribute("message","bạn cần đăng nhập để thực hiện chức năng này");
                    response.sendRedirect("/dang-nhap");
                }
                else {
                    if(user.getBlance()>=chapter.getPrice()){
                        ComicDTO comic= comicService.findComicSelectWhereShow(idComic);
                        Chapter chapterDTO = chapterService.selectChapter(chapterId);
                        int indexNext=-1;
                        int indexPrev=-1;
                        Collections.reverse(comic.getChapters());
                        for (int i=0;i<comic.getChapters().size();i++){
                        if(comic.getChapters().get(i).getId()==chapterDTO.getId()){
                            if(i==0){
                                indexPrev=++i;
                                break;
                            }
                            else if(i>0&&i+1==comic.getChapters().size()){
                                indexNext=i-1;
                                break;
                            }
                            else if(i>0 && i+1<comic.getChapters().size()){
                                indexNext=i-1;
                                indexPrev=i+1;
                                break;
                            }
                            else if(i+1==comic.getChapters().size()){
                                indexNext=i-1;
                                break;
                            }
                             }
                        }
//                        chapters = chapters.stream().sorted(Comparator.comparing(ChapterDTO::getName)).collect(Collectors.toList());
//                        boolean disableHead = false;
//                        boolean disabledTail = false;
//                        if(chapters.size() < 1){
//                            disableHead = true;
//                            disabledTail = true;
//                        }
//                        if(chapters.size() >1){
//                            // thang dau
//                            if(chapters.get(0).getId()== chapterDTO.getId()){
//                                disableHead = true;
//                            }
//                            if(chapters.get(chapters.size() -1).getId()== chapterDTO.getId()){
//                                disabledTail = true;
//                            }
//                        }
                        request.setAttribute("listPage",pageService.selectAllPageByIdChapter(chapter.getId()));
                        request.setAttribute("comic", comicService.findComicSelectWhereShow(idComic));
                        request.setAttribute("chapter",chapterService.selectChapter(chapterId));
                        request.setAttribute("indexNext",indexNext);
                        request.setAttribute("indexPrev",indexPrev);
                        request.setAttribute("comicSort", comic);
                        if(orderService.findOrderWhereUserAndChapter(user.getId(),chapter.getId())){
                            chapter.setView(chapter.getView()+1);
                            chapterService.updateChapterView(chapter);
                            request.getRequestDispatcher("/user/views/page.jsp").forward(request, response);
                        }
                        else {
                            chapter.setView(chapter.getView()+1);
                            chapterService.updateChapterView(chapter);
                            Order order = new Order(user.getId(), chapter.getId(), chapter.getPrice());
                            orderService.insertOrder(order);
                            user.setBlance(user.getBlance() - chapter.getPrice());
                            user.setPoin(user.getPoin() + chapter.getPrice());
                            user.setOrders(orderService.selectOrderByIdUser(user.getId()));
                            userService.updateUser(user);
                            request.getRequestDispatcher("/user/views/page.jsp").forward(request, response);
                        }
                    }
                    else {
                        session.setAttribute("message","Số tiền không đủ bạn cần nạp tiền ");
                        response.sendRedirect("/thanh-toan");
                    }
                }
            }
            else {
                ComicDTO comic= comicService.findComicSelectWhereShow(idComic);
                Chapter chapterDTO = chapterService.selectChapter(chapterId);
                int indexNext=-1;
                int indexPrev=-1;
                Collections.reverse(comic.getChapters());
                if(comic.getChapters().size()>1){
                    for (int i=0;i<comic.getChapters().size();i++){
                        if(comic.getChapters().get(i).getId()==chapterDTO.getId()){
                            if(i==0){
                                indexPrev=++i;
                                break;
                            }
                            else if(i>0&&i+1==comic.getChapters().size()){
                                indexNext=i-1;
                                break;
                            }
                            else if(i>0 && i+1<comic.getChapters().size()){
                                indexNext=i-1;
                                indexPrev=i+1;
                                break;
                            }
                            else if(i+1==comic.getChapters().size()){
                                indexNext=i-1;
                                break;
                            }
                        }
                    }
                }
                chapter.setView(chapter.getView()+1);
                request.setAttribute("listPage",pageService.selectAllPageByIdChapter(chapter.getId()));
                request.setAttribute("chapter",chapterService.selectChapter(chapterId));
                request.setAttribute("comic", comicService.findComicSelectWhereShow(idComic));
                request.setAttribute("comicSort", comic);
                request.setAttribute("indexNext",indexNext);
                request.setAttribute("indexPrev",indexPrev);
                request.getRequestDispatcher("/user/views/page.jsp").forward(request,response);
            }
        }
        catch (SQLException e){

        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

    }
}
