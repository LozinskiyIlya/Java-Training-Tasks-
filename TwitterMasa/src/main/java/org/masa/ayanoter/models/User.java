package org.masa.ayanoter.models;


import com.mysql.jdbc.Blob;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String login;

    public java.sql.Blob image;


    @OneToMany (mappedBy = "user")
    @OrderBy("date DESC")
    public List<Post> posts = new ArrayList<>();

    @OneToMany (mappedBy = "user")
    public List<Comment> comments = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public java.sql.Blob getImage() {
        return image;
    }

    public void setImage( java.sql.Blob image) {
        this.image = image;
    }

}
