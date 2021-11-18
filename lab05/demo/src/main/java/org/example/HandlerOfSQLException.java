package org.example;

import org.apache.log4j.Logger;
import java.sql.SQLException;

public class HandlerOfSQLException implements HandlerOfErrors{
    private final Logger logger = Logger.getLogger(HandlerOfSQLException.class.getName());
    @Override
    public String getMessage() {
        return "Could not connect to database. Check your internet connection";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof SQLException;
    }

    @Override
    public boolean handle(Exception e, SupplierOfErrors method) {
        if (canHandle(e)) {
            System.out.println("Trying to reconnect to database...");
            Behavior.wait(2);
            if (Behavior.repeatOperation(method, 3)) {
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
