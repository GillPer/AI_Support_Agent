package com.example.aisupport.dto;

public class SupportRequest {
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SupportRequest{" +
                "message='" + message + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
