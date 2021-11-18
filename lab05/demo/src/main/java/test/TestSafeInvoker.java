package test;

import org.example.SafeInvoker;
import org.example.errors.SQLError;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class TestSafeInvoker {
    SafeInvoker safeInvoker = new SafeInvoker();

    @Test
    public void ClassNotFoundException() {
        safeInvoker.invoke(() -> {
            throw new ClassNotFoundException();
        });
    }

    @Test
    public void TimeoutException() {
        safeInvoker.invoke(() -> {
            throw new TimeoutException();
        });
    }

    @Test
    public void FileNotFoundException() {
        safeInvoker.invoke(() -> {
            throw new FileNotFoundException();
        });
    }

    @Test
    public void SQLExceptionIsHandled() {
        safeInvoker.invoke(() -> {
            throw new SQLException();
        });
    }

    @Test
    public void TimeoutExceptionIsHandled() {
        safeInvoker.invoke(() -> {
            throw new TimeoutException();
        });
    }
}
