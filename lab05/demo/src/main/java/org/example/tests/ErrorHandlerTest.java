package org.example.tests;

import org.example.SafeInvoker;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.security.KeyException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class ErrorHandlerTest {

    SafeInvoker safeInvoker= new SafeInvoker();

    @Test
    public void CheckIfFileNotFoundExceptionIsHandled(){
        safeInvoker.invoke(()->{throw new FileNotFoundException();});
    }

    @Test
    public void CheckIfClassNotFoundErrorIsHandled(){
        safeInvoker.invoke(()->{throw new ClassNotFoundException();});
    }

    @Test
    public void CheckIfBasicErrorIsHandled(){
        safeInvoker.invoke(()->{throw new KeyException();});
    }

    @Test
    public void CheckIfSQLExceptionIsHandled(){
        safeInvoker.invoke(()->{throw new SQLException();});
    }

    @Test
    public void CheckIfTimeoutExceptionIsHandled(){
        safeInvoker.invoke(()->{throw new TimeoutException();});
    }

}
