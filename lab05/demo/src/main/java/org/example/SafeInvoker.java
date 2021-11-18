package org.example;

import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<HandlerOfErrors> handlersOfErrors = new ArrayList<>(List.of(
            new HandlerOfFileNotFounding(),
            new HandlerOfTimeout(),
            new HandlerOfNotFoundingClass(),
            new HandlerOfSQLException()
    ));

    public void invoke(SupplierOfErrors method){
        String log4jConfPath = "src/main/Logs/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        DefaultHandlerOfErrors defaultHandlerOfErrors = new DefaultHandlerOfErrors();
        try {
            method.execute();
        } catch (Exception e){
            AtomicBoolean wasHandled = new AtomicBoolean(false);
            handlersOfErrors.stream()
                    .filter(errorHandler -> errorHandler.canHandle(e))
                    .forEach(errorHandler -> {
                        errorHandler.handle(e,method);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) defaultHandlerOfErrors.handle(e,method);
        }

    }
}
