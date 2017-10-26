package com.codefellows;

public class CodeFellowsException extends Exception {
    public CodeFellowsException(String msg) {
        super(msg);
    }

    public CodeFellowsException(String msg, Throwable t) {
        super(msg, t);
    }
}
