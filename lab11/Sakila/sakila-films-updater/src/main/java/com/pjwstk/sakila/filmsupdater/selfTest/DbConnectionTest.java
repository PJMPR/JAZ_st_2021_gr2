package com.pjwstk.sakila.filmsupdater.selfTest;

import com.pjwstk.sakila.diagnostics.selfTest.SelfTest;
import com.pjwstk.sakila.diagnostics.selfTest.SelfTestResult;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbConnectionTest extends SelfTest {

    public DbConnectionTest() {
        name = "DbConnectionTest";
        text = "Checking for connection with database...";
    }

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selfTestResult = new SelfTestResult(name, text, false, errors);
        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
        String username = "admin";
        String password = "admin";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password);) {
            selfTestResult.setPassed(true);
        }

        catch (SQLException exception) {
            selfTestResult.setPassed(false);
            errors.add("Sql connection failed " + exception.getMessage() + Arrays.toString(exception.getStackTrace()));
        }
        return selfTestResult;
    }

}
