package org.example.loggers;

public class Logger {

    final static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(Logger.class);

    public void log(String message){
        l.error(message);
    }

    public void log(String message, Exception error){
        l.error(message,error);
    }

}
