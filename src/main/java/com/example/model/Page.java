package com.example.model;

import com.example.model.DTO.PageDTO;

public class Page {
    private int id;
    private int idChapter;
    String link;
    private int index;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getIdChapter() {
        return idChapter;
    }

    public String getLink() {
        return link;
    }

    public Page(int idChapter, String link, int index, String name) {
        this.idChapter = idChapter;
        this.link = link;
        this.index = index;
        this.name = name;
    }
    public Page(){

    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdChapter(int chapter) {
        this.idChapter = chapter;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public PageDTO convertPageDTO(){
        PageDTO pageDTO=new PageDTO();
        pageDTO.setId(this.id);
        pageDTO.setIdChapter(this.idChapter);
        pageDTO.setLink(this.link);
        pageDTO.setName(this.name);
        pageDTO.setIndex(this.index);
        return pageDTO;
    }
}
