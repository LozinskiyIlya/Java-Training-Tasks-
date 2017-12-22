package org.masa.ayanoter.models;

public class JsonResponseLikeRepost {

    private String status = "";
    private String errorMessage = "";
    private String l_count;
    private String r_count;

    public JsonResponseLikeRepost(String ok, String s, Post post) {
        this.l_count=String.valueOf(post.l_count);
        this.r_count = String.valueOf(post.r_count);
        this.status = ok;
        this.errorMessage = s;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getL_count() {
        return l_count;
    }

    public void setL_count(String l_count) {
        this.l_count = l_count;
    }

    public String getR_count() {
        return r_count;
    }

    public void setR_count(String r_count) {
        this.r_count = r_count;
    }
}
