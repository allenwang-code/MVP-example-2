package com.mvp.example.data.remote;

public class APIError {

    private int status;
    private String message;

    public APIError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}