package org.example.errors;

import org.apache.log4j.Logger;
import org.example.Repeater;
import org.example.Supplier;

import java.util.concurrent.TimeoutException;

public class TimeoutError implements ErrorHandler {
    private final Logger logger = Logger.getLogger(TimeoutError.class.getName());

    @Override
    public String getMessage() {
        return "Connection timed out";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof TimeoutException;
    }

    @Override
    public boolean handle(Exception exception, Supplier method) {
        if (canHandle(exception)) {
            System.out.println("Connection timed out. Retrying..");
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
