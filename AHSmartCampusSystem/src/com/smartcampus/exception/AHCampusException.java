package com.smartcampus.exception;

public class AHCampusException extends Exception {
    public AHCampusException(String msg) {
        super("Campus System Alert: " + msg);
    }
}