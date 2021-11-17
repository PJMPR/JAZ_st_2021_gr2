package org.example.handlers;

import org.apache.log4j.Logger;
import org.example.Fixer;
import org.example.Provider;
import java.sql.SQLException;

public class SQLExceptionH implements Handler {
    private final Logger logger = Logger.getLogger(SQLExceptionH.class.getName());
    @Override
    public String info() {
        return "NO CONNECTION";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof SQLException;
    }

    @Override
    public boolean handle(Exception e, Provider method) {
        if (canHandle(e)) {
            Fixer.wait(2);
            if (Fixer.reapeat(method, 3)) {
                return true;
            }
            log();
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(info());
    }
}