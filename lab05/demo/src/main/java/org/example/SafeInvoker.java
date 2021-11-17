package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.handlers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
   List<Handler> HandlersList = new ArrayList<>(List.of(new TimeOut(), new ClassNotFound(), new SQLExceptionH()));

    public void invoke(Provider action){
        PropertyConfigurator.configure("src/main/java/org/example/log4.properties");
        DefaultError defaultErrorHandler = new DefaultError();
        try {
            action.execute();
        } catch (Exception e){

            AtomicBoolean wasHandled = new AtomicBoolean(false);

            HandlersList.stream()
                    .filter(errorHandler -> errorHandler
                            .canHandle(e))
                    .forEach(handler -> {
                        handler
                                .handle(e,action);
                        wasHandled
                                .set(true);
                    });
            if (!wasHandled.get()) defaultErrorHandler.handle(e,action);
        }
    }
} 