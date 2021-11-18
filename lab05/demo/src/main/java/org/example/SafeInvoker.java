package org.example;

import org.example.errors.*;
import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<ErrorHandler> errorHandlers = new ArrayList<>(List.of(
            new FileNotFoundError(),
            new ClassNotFoundError(),
            new TimeoutError(),
            new SQLError()
    ));

    public void invoke(Supplier method) {
        String log4jConfigurationPath = "src/main/Logs/log4j.properties";
        PropertyConfigurator.configure(log4jConfigurationPath);
        DefaultError defaultHandler = new DefaultError();
        try {
            method.execute();
        } catch (Exception exception) {
            AtomicBoolean isHandled = new AtomicBoolean(false);
            errorHandlers.stream()
                        .filter(exceptionHandler -> exceptionHandler.canHandle(exception))
                        .forEach(exceptionHandler -> {
                            exceptionHandler.handle(exception, method);
                            isHandled.set(true);
                        });
            if (!isHandled.get()) {
                defaultHandler.handle(exception, method);
            }
        }
    }
}
