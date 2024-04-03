package com.example.demo.Model;

public class Post {

    private int id;
    private String title;
    private String content;
    private String category;

    public Post()
    {

    }

    public Post(int id, String title, String content, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Post(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
