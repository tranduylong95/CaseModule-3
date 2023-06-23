package com.example.model.DTO;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChapterDTO {
    private int id;
    private String name;
    private byte lock;
    private int view;
    private int price;
    private byte show;
    private int idComic;
    private long timeLock;
    private Timestamp createAt;
    private Timestamp updateAt;
    private List<PageDTO> listPageDTO;

    public ChapterDTO() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getLock() {
        return lock;
    }

    public int getView() {
        return view;
    }

    public int getPrice() {
        return price;
    }

    public byte getShow() {
        return show;
    }

    public int getIdComic() {
        return idComic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLock(byte lock) {
        this.lock = lock;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setShow(byte show) {
        this.show = show;
    }

    public void setIdComic(int idComic) {
        this.idComic = idComic;
    }

    public void setTimeLock(long timeLock) {
        this.timeLock = timeLock;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public void setListPageDTO(List<PageDTO> listPageDTO) {
        this.listPageDTO = listPageDTO;
    }

    public long getTimeLock() {
        return timeLock;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public List<PageDTO> getListPageDTO() {
        return listPageDTO;
    }
    public String parseCreatAt(){
        LocalDateTime currentTime = LocalDateTime.now();

        // Thời gian đã cho
        LocalDateTime givenTime = createAt.toLocalDateTime();

        // Tính khoảng thời gian giữa thời gian hiện tại và thời gian đã cho
        Duration duration = Duration.between(givenTime, currentTime);

        // Xử lý và tạo chuỗi kết quả dựa trên quy tắc của bạn
        String result;
        if (duration.toMinutes() < 1) {
            result = "1 phút trước";
        } else if (duration.toMinutes() < 60) {
            result = duration.toMinutes() + " phút trước";
        } else if (duration.toHours() < 24) {
            result = duration.toHours() + " giờ trước";
        } else if (duration.toDays() < 30) {
            result = duration.toDays() + " ngày trước";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            result = givenTime.format(formatter);
        }
        return result;
    }
}
