package org.example.errors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DivByZero implements ErrorHandler {

    private Logger logger = LogManager.getLogger(getClass().getSimpleName());

    @Override
    public String errorMessage() {
        return "Divide by zero!";
    }

    @Override
    public boolean tryDoIt() {
        try
        {
            int data=50/0;
            System.out.println("rest of the code");
            return true;
        }

        catch(ArithmeticException e)
        {
            return false;
        }
    }

    @Override
    public void fix() {
        if (!tryDoIt()) {
            System.out.println(errorMessage());
            System.out.println("You cant divide by zero. Change number and try again");
            logger.info(errorMessage());
        }
    }
    }

