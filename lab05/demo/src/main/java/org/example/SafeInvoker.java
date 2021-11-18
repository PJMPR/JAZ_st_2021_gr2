package org.example;

import org.example.handlers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class SafeInvoker {
    List<ErrorHandler> errorHandlersList = new ArrayList<>(List.of(
            new FileNotFound(),
            new Timeout(),
            new ClassNotFound()
    ));


    DefaultError defaultError = new DefaultError();

    public void invoke(Provider method){

        try {
            method.execute();
        } catch (Exception err){
            AtomicBoolean wasHandled = new AtomicBoolean(false);
            errorHandlersList.stream()
                    .filter(errorHandler -> errorHandler.canHandle(err))
                    .forEach(errorHandler -> {
                        errorHandler.handle(err,method);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) defaultError.handle(err,method);
        }

    }
}