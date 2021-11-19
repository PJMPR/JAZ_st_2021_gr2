package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider.Provider;
import org.example.Repeater.Repeater;

import java.sql.SQLException;

public class SQLExceptionHandler implements Handler {
    private final Logger logger = Logger.getLogger(SQLExceptionHandler.class.getName());

    @Override
    public String getMessage() {
        return "Cant connect to database";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof SQLException;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        if (canHandle(exception)) {
            System.out.println("Trying to reconnect to database...");

            try {
                Thread.sleep(3 + 1000L);
            } catch (Exception exception_catch) {
                exception_catch.printStackTrace();
            }

            if (Repeater.repeater(method, 3)) {
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