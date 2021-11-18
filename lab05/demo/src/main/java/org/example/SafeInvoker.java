package org.example;

import org.example.Handlers.*;
import org.example.Supplier.Supplier;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<ExceptionHandler> exceptionsHandlersList = new ArrayList<>(List.of(
            new ClassNotFoundExceptionHandler(),
            new FileNotFoundExceptionHandler(),
            new SQLExceptionHandler(),
            new TimeOutHandler()
    ));



    DefaultExceptionHandler defaultExceptionHandler = new DefaultExceptionHandler();

    public void invoke(Supplier method){

        try {
            method.execute();
        } catch (Exception exc){
            AtomicBoolean wasHandled = new AtomicBoolean(false);

            exceptionsHandlersList.stream()
                    .filter(exceptionHandler -> exceptionHandler.canHandle(exc))
                    .forEach(exceptionHandler -> {
                        exceptionHandler.handle(method, exc);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) defaultExceptionHandler.handle(method, exc);
        }

    }

}
