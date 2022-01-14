package com.pjwstk.sakila.diagnostics.selftests;

import java.io.File;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import org.springframework.stereotype.Component;

@Component
public class DiskStorageSelfTest extends SelftestBase {


    @Override
    public String getName() {
        return "CheckStorageForLogs";
    }

    @Override
    public String getDescription() {
        return "Checking that there is more than 5% free storage";
    }


    @Override
    public SelfTestResult execute() {
        SelfTestResult selfTestResult = new SelfTestResult(getName(), getDescription(), false, null);

        File file = new File("/Users/maciejdubowik");
        double freeSpace = (double)(file.getTotalSpace() - file.getFreeSpace()) / file.getTotalSpace();
        selfTestResult.setPassed(freeSpace > 0.05);

        return selfTestResult;
    }
}
