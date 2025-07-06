package com.example.BE_Tinder_App.exeption;

public class InvalidException extends RuntimeException {
    public InvalidException(String msg) {
        super(msg);
    }
}
