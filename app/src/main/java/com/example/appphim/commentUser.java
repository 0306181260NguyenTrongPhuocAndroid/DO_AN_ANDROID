package com.example.appphim;

public class commentUser {
    private int userId;
    private String userName;
    private String userComment;

    public commentUser(int userId, String userName, String userComment) {
        this.userId = userId;
        this.userName = userName;
        this.userComment = userComment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
