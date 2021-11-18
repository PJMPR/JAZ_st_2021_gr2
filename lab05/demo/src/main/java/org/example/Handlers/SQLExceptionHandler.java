package org.example.Handlers;

import org.example.Supplier.Supplier;

import java.sql.SQLException;

public class SQLExceptionHandler implements ExceptionHandler{
    @Override
    public String getMessage() {
        return "Could not connect to database. Check your internet connection";
    }

    @Override
    public void handle(Supplier method, Exception exc) {
        if (canHandle(exc)) {

            System.out.println("Could not connect to database. Reconnecting...");
            actions.wait(2);

            if (actions.repeat(method, 5)) {
                return;
            }
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }


    @Override
    public boolean canHandle(Exception exc) {
        return exc instanceof SQLException;
    }
}
