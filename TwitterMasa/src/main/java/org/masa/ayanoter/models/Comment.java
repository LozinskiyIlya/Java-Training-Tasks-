package org.masa.ayanoter.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @ManyToOne
    public Post post;

    @ManyToOne
    public User user;

    public String text;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public Calendar date;

    public Comment() {
    }

    public Comment(Post post, User user, String text) {
        this.post = post;
        this.user = user;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date.getTime().toLocaleString();
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
