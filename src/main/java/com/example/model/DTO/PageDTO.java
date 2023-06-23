package com.example.model.DTO;

public class PageDTO {
    private int id;
    private int idChapter;
    String link;
    private int index;
    private String name;

    public int getId() {
        return id;
    }

    public PageDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdChapter() {
        return idChapter;
    }

    public String getLink() {
        return link;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
