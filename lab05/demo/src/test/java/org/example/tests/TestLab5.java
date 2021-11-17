package org.example.tests;

import org.example.SafeInvoker;
import org.junit.Test;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class TestLab5 {
    SafeInvoker safeInvoker = new SafeInvoker();

    @Test
    public void AnyException(){
        safeInvoker.invoke(() ->{throw new Exception();});
    }

    @Test
    public void ThrowRuntimeException(){
        safeInvoker.invoke(() ->{throw new RuntimeException();});
    }

    @Test
    public void ThrowTimeout(){
        safeInvoker.invoke(() ->{throw new TimeoutException();});
    }

    @Test
    public void ThrowSQLException(){
        safeInvoker.invoke(() ->{throw new SQLException();});
    }

    @Test
    public void ThrowClassNotFoundException(){
        safeInvoker.invoke(() ->{throw new ClassNotFoundException();});
    }
}
