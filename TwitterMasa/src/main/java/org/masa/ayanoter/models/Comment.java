package org.masa.ayanoter.models;

import java.util.Date;

public class Comment {
    public String author;
    public String text;
    public String date;


    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
        this.date = new Date().toLocaleString();
    }
}
