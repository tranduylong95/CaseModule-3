package com.example.controller.user;

import com.example.controller.admin.ComicServlet;
import com.example.model.Comic;
import com.example.model.DTO.ComicDTO;
import com.example.repository.IComic;
import com.example.repository.user.IComicUser;
import com.example.service.ComicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/trang-chu","/hot","/truyen-con-trai","/truyen-con-gai"})
public class HomeServlet extends HttpServlet {
    private IComicUser comicService;

    @Override
    public void init() throws ServletException {
        comicService=new ComicService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action){
            case "/trang-chu":
                showHome(request,response);
                break;
            case "/hot":
                showHot(request,response);
                break;
            case "/truyen-con-trai":
                showComicSex(request,response,1);
                break;
            case "/truyen-con-gai":
                showComicSex(request,response,0);
                break;
            case "/":
                showHome(request,response);
                break;
        }
    }
    private void showHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int page;
        if(request.getParameter("page")==null){
            page=1;
        }
        else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        List<ComicDTO> listComic= comicService.selectComicOrderBy(page);
        int totalComic=comicService.totalPage("SELECT COUNT(*) AS total_count\n" +
                "FROM (\n" +
                "    SELECT co.id\n" +
                "    FROM comics co\n" +
                "    JOIN categories cts ON co.id = cts.id_comics\n" +
                "    JOIN category ct ON ct.id = cts.id_category\n" +
                "    LEFT JOIN (SELECT * FROM chapter WHERE chapter.show = 1) cp ON co.id = cp.id_comics\n" +
                "    LEFT JOIN page pg ON pg.id_chapter = cp.id\n" +
                "    WHERE co.show = 1\n" +
                "    GROUP BY co.id\n" +
                ") AS subquery;");
        request.setAttribute("page",page);
        request.setAttribute("listComic",listComic);
        request.setAttribute("totalComic",totalComic);
        request.getRequestDispatcher("/user/views/home.jsp").forward(request,response);

    }
    private void showHot(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        List<ComicDTO> listComic= comicService.selectComicOrderByWhereHot();
        request.setAttribute("listComic",listComic);
        request.getRequestDispatcher("/user/views/home.jsp").forward(request,response);
    }
    private void showComicSex(HttpServletRequest request, HttpServletResponse response,int sex)throws IOException, ServletException{
        List<ComicDTO> listComic= comicService.selectComicOrderByWhereSex(sex);
        request.setAttribute("listComic",listComic);
        request.getRequestDispatcher("/user/views/home.jsp").forward(request,response);
    }
}
