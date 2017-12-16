package org.masa.ayanoter.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    public String author;
    public String text;
    public String date;
    public int likeCount;
    public int repostCount;
    public List<Comment> comments;


    public Post(String author, String text) {
        this.author = author;
        this.text = text;
        this.date = new Date().toLocaleString();
        this.likeCount = 0;
        this.repostCount = 0;
        this.comments = new ArrayList<>();
    }

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void increaseRepostCount() {
        this.repostCount++;
    }

    public String getLikeCount() {
        return "   " + this.likeCount;
    }

    public String getRepostCount() {
        return "   " + this.repostCount;
    }

    public void addComment(String newUser, String comtext) {
    comments.add(0,new Comment(newUser, comtext));
    }

    public int getId(){
        return this.hashCode();
    }
}
