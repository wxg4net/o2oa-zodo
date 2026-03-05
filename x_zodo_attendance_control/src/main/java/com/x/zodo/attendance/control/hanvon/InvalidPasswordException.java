package com.x.zodo.attendance.control.hanvon;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Invalid password: must be 1-8 digits");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}