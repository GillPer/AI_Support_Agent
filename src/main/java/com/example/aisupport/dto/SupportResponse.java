package com.example.aisupport.dto;

public class SupportResponse {

    private String category;
    private String priority;
    private String action;
    private String resolution;
    private boolean escalate;
    private double confidence;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isEscalate() {
        return escalate;
    }

    public void setEscalate(boolean escalate) {
        this.escalate = escalate;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}