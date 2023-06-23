package com.example.model;

import com.example.model.DTO.CategoryDTO;

public class Category {
    private int id;
    private String name;
    private String describe;

    public Category() {
    }

    public Category(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public CategoryDTO convertCategoryDTO(){
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(this.id);
        categoryDTO.setName(this.name);
        categoryDTO.setDescribe(this.describe);
        return categoryDTO;
    }
}
