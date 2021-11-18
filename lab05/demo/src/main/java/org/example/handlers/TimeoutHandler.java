package org.example.handlers;

import org.example.supplier.BasicSupplier;
import java.util.concurrent.TimeoutException;

public class TimeoutHandler implements ErrorHandler{

    @Override
    public String getMessage() {
        return "Connection timed out.";
    }

    @Override
    public void handle(Exception error, BasicSupplier method) {
        if (canHandle(error)) {
            System.out.println("Connection timed out. Trying to reconnect ...");
            waiting.wait(2);
            if (waiting.redo(method,5)) {
                return;
            }
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception error) {
        return error instanceof TimeoutException;
    }

}
