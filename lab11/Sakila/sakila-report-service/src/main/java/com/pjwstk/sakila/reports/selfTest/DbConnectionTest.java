package com.pjwstk.sakila.reports.selfTest;

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
        description = "Test check if there is connection with database";
    }

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selfTestResult = new SelfTestResult(name, description, false, errors);
        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "password";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password);) {
            selfTestResult.setPassed(true);
        }

        catch (SQLException exception) {
            selfTestResult.setPassed(false);
            errors.add("Sql connection failed" + exception.getMessage() + Arrays.toString(exception.getStackTrace()));
        }
        return selfTestResult;
    }

}

