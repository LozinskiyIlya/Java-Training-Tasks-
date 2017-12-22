package org.masa.ayanoter.models;

public class JsonResponseComment {

    private String status = "";
    private String errorMessage = "";
    private String ComText;
    private String author;
    private String date;

    public JsonResponseComment(String status, String errorMessage, Comment comment) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.ComText = comment.text;
        this.author = comment.user.login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getComText() {
        return ComText;
    }

    public void setComText(String text) {
        this.ComText = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
