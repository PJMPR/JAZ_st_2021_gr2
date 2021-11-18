package org.example.handlers;

import org.example.supplier.BasicSupplier;
import java.sql.SQLException;

public class SQLExceptionHandler implements ErrorHandler{

    @Override
    public String getMessage() {
        return "Could not connect to database.";
    }

    @Override
    public void handle(Exception error, BasicSupplier method) {
        if (canHandle(error)) {

            System.out.println("Could not connect to database. Reconnecting ...");
            waiting.wait(2);

            if (waiting.redo(method, 5)) {
                return;
            }
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }


    @Override
    public boolean canHandle(Exception error) {
        return error instanceof SQLException;
    }

}
