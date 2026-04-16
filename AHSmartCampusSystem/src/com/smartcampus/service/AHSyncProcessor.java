package com.smartcampus.service;

public class AHSyncProcessor extends Thread {
    private String ahStudentName;

    public AHSyncProcessor(String studentName) {
        this.ahStudentName = studentName;
    }

    public void run() {
        try {
            System.out.println("\n[SYSTEM] Verifying enrollment for: " + ahStudentName + "...");
            Thread.sleep(2500); // Simulate processing
            System.out.println("[SYSTEM] Verification Complete for " + ahStudentName + ".");
        } catch (InterruptedException e) {
            System.out.println("Thread Error: " + e.getMessage());
        }
    }
}