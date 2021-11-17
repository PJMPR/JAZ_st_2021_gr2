package org.example.handlers;

import org.example.Provider;

public interface Handler {
    String info();
    boolean canHandle(Exception exception);
    boolean handle(Exception exception, Provider method);
    void log();
}