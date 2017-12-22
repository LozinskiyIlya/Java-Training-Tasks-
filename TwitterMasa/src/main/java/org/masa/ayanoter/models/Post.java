package org.masa.ayanoter.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @ManyToOne
    public User user;

    public String text;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public Calendar date;

    public Integer l_count;

    public Integer r_count;


    @OneToMany(mappedBy = "post")
    public List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(Integer id, User user, String text, Integer l_count, Integer r_count) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.l_count = l_count;
        this.r_count = r_count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date.getTime().toLocaleString();
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getL_count() {
        return l_count;
    }

    public void setL_count(Integer l_count) {
        this.l_count = l_count;
    }

    public Integer getR_count() {
        return r_count;
    }

    public void setR_count(Integer r_count) {
        this.r_count = r_count;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}