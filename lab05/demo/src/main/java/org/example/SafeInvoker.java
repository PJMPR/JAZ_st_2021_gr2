package org.example;

import org.example.handlers.*;
import org.example.supplier.BasicSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {

    List<ErrorHandler> errorHandlersList = new ArrayList<>(List.of(
            new FileNotFoundErrorHandler(),
            new TimeoutHandler(),
            new SQLExceptionHandler(),
            new ClassNotFoundErrorHandler()
    ));

    BasicErrorHandler basicErrorHandler = new BasicErrorHandler();

    public void invoke(BasicSupplier method){

        try {
            method.execute();
        } catch (Exception error){
            AtomicBoolean wasHandled = new AtomicBoolean(false);
            errorHandlersList.stream()
                    .filter(errorHandler -> errorHandler.canHandle(error))
                    .forEach(errorHandler -> {
                        errorHandler.handle(error,method);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) basicErrorHandler.handle(error,method);
        }

    }

}
