package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.example.errors.DivByZero;
import org.example.errors.FileNotFound;
import org.example.errors.InternetConnectionLost;

public class App {

    public static void main(String[] args) {
        SafeInvoker safeInvoker = new SafeInvoker();
        safeInvoker.invoke();
    }
}
