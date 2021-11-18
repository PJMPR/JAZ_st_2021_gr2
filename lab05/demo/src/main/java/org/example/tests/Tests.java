package org.example.tests;

import org.example.SafeInvoker;
import org.example.errors.DivByZero;
import org.example.errors.FileNotFound;
import org.example.errors.InternetConnectionLost;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class Tests
{


    @Test
    public void waitingDidntFixTheProblem(){
        InternetConnectionLost internetConnectionLost = new InternetConnectionLost();
        assertFalse(internetConnectionLost.tryDoIt());

    }

    @Test
    public void fileNotFoundErrorMessage() {

        FileNotFound fileNotFound = new FileNotFound();
        assertEquals("File not found!", fileNotFound.errorMessage());
    }

    @Test
    public void cantDivByZero(){
        DivByZero divByZero = new DivByZero();
        assertFalse(divByZero.tryDoIt());
        assertEquals("Divide by zero!", divByZero.errorMessage());
    }

    @Test
    public void numberOfDeclaratedErrorsEquals3(){
        SafeInvoker safeInvoker = new SafeInvoker();
        assertEquals(3, safeInvoker.errorList.count());
    }
}
