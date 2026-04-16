package com.smartcampus.model;

import java.io.Serializable;

public class AHCourseModule implements Serializable {
    private String ahCode; // Changed to String
    private String ahTitle;
    private double ahTuition;

    public AHCourseModule(String code, String title, double tuition) {
        this.ahCode = code;
        this.ahTitle = title;
        this.ahTuition = tuition;
    }

    public String getCode() { return ahCode; } // Returns String
    public String getTitle() { return ahTitle; }
    public double getTuition() { return ahTuition; }
}