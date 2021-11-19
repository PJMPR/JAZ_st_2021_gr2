package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider.Provider;
import org.example.Repeater.Repeater;

import java.util.concurrent.TimeoutException;

public class TimeOutHandler implements Handler {
    private final Logger logger = Logger.getLogger(TimeOutHandler.class.getName());

    @Override
    public String getMessage() {
        return "Connection timed out, check internet connection";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof TimeoutException;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        if (canHandle(exception)) {
            System.out.println("Connection timed out. Retrying...");

            try {
                Thread.sleep(2 + 1000L);
            } catch (Exception exception1) {
                exception1.printStackTrace();
            }

            if (Repeater.repeater(method,3)) {
                return true;
            }
            System.out.println(getMessage());
            log();
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}