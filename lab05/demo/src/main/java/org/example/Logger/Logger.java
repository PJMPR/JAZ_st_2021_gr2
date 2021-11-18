package org.example.Logger;

public class Logger {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(org.apache.log4j.Logger.class);


    public void log(String msg){
        logger.error(msg);
    }

    public void log(String msg, Exception err){
        logger.error(msg,err);
    }
}
