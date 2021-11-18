package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.errors.DivByZero;
import org.example.errors.ErrorHandler;
import org.example.errors.FileNotFound;
import org.example.errors.InternetConnectionLost;

import java.util.stream.Stream;

public class SafeInvoker {

    public Stream<ErrorHandler> errorList = Stream.of(new InternetConnectionLost(),new FileNotFound(),new DivByZero());

    public void invoke() {
        PropertyConfigurator.configure("src/main/java/org/example/log4j.properties");
        errorList.forEach(i -> {
            if(!i.tryDoIt()){
                i.fix();
            }
        });
    }

    }


