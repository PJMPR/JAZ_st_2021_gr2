package com.pjwstk.sakila.filmsupdater.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftests.SelftestBase;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SakilaDbConnectionSelftest extends SelftestBase {

    @Override
    public String getName() {
        return "CheckDbConnection";
    }

    @Override
    public String getDescription() {
        return "checking if there is a connection to the database";
    }



    @Override
    public SelfTestResult execute() {
        SelfTestResult selfTestResult = new SelfTestResult(getName(), getDescription(), false, null);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "password");
            selfTestResult.setPassed(con.isValid(0));
        } catch (SQLException e) {
            e.printStackTrace();
            selfTestResult.setPassed(false);
        }
        return selfTestResult;
    }
}
