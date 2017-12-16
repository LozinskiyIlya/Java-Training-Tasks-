package org.masa.ayanoter.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    public String login;
    public String password;
    public String email;
    public String name;
    public String lastName;
    public Date firstTimeRegistred;

    public List<User> subscribes;
    public List<User> subscribers;
    public List<Post> posts;

    public User() {
        firstTimeRegistred = new Date();
        subscribes = new ArrayList<>();
        subscribers = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public User(String login, String password, String email, String name, String lastName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        firstTimeRegistred = new Date();
        subscribes = new ArrayList<>();
        subscribers = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getFirstTimeRegistred() {
        return firstTimeRegistred;
    }

    public void setFirstTimeRegistred(Date firstTimeRegistred) {
        this.firstTimeRegistred = firstTimeRegistred;
    }

    public List<User> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<User> subscribes) {
        this.subscribes = subscribes;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
