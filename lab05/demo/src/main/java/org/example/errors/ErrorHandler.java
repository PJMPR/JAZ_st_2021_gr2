package org.example.errors;

public interface ErrorHandler {
    String errorMessage();
    boolean tryDoIt();
    void fix();
}
