package org.example.errors;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.example.Repeater;
import org.example.Supplier;

public class SQLError implements ErrorHandler {
    private final Logger logger = Logger.getLogger(SQLError.class.getName());


    @Override
    public String getMessage() {
        return "Connection attempt failed";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof SQLException;
    }

    @Override
    public boolean handle(Exception exception, Supplier method) {
        if (canHandle(exception)) {
            System.out.println("Trying to reconnect to database");
            try {
                Thread.sleep(3 + 1000L);
            } catch (Exception exception1) {
                exception1.printStackTrace();
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
