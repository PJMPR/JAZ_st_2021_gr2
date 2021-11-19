package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.Handlers.*;
import org.example.Provider.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<Handler> handlersList = new ArrayList<>(List.of(
            new FileNotFoundHandler(),
            new ClassNotFoundHandler(),
            new TimeOutHandler(),
            new SQLExceptionHandler()
    ));

    public void invoke(Provider method) {
        String log4jConfigurationPath = "src/main/java/org/example/logs/log4j.properties";
        PropertyConfigurator.configure(log4jConfigurationPath);

        DefaultErrorHandler defaultHandler = new DefaultErrorHandler();

        try {
            method.execute();
        } catch (Exception exception) {
            AtomicBoolean isHandled = new AtomicBoolean(false);
            handlersList.stream()
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