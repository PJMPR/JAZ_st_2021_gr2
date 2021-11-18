package org.example.tests;

import org.example.SafeInvoker;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.security.KeyException;
import java.util.concurrent.TimeoutException;


public class SafeInvokerTest {

    SafeInvoker safeInvoker= new SafeInvoker();
    @Test
    public void FileNotFoundExceptionThrown(){
        safeInvoker.invoke(()->{throw new FileNotFoundException();});
    }

    @Test
    public void ClassNotFoundExceptionThrown(){
        safeInvoker.invoke(()->{throw new ClassNotFoundException();});
    }

    @Test
    public void DefaultExceptionThrown(){
        safeInvoker.invoke(()->{throw new KeyException();});
    }


    @Test
    public void TimeoutExceptionThrown(){
        safeInvoker.invoke(()->{throw new TimeoutException();});
    }
}
