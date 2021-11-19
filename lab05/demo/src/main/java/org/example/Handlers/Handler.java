package org.example.Handlers;

import org.example.Provider.Provider;

public interface Handler {
    String getMessage();
    boolean canHandle(Exception exception);
    boolean handle(Exception exception, Provider method);
    void log();
}