package com.pjwstk.sakila.diagnostics.selfTest;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiskStorageTest extends SelfTest{
    private static final int diskCapacity = 5;
    
    public DiskStorageTest() {
        name = "DiskStorageTest";
        description = "Checking for at least 5% disk space available";
    }

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selftestResult = new SelfTestResult(name, description, false, errors);

        if(getUsableDiscSpacePercentage() >= diskCapacity) selftestResult.setPassed(true);
        else {
            selftestResult.setPassed(false);
            errors.add(String.format("Not enough disk space, required %d percent, got %x percent", diskCapacity, getUsableDiscSpacePercentage()));
        }

        return selftestResult;
    }

    public long getUsableDiscSpacePercentage(){
        File file = new File("c:");
        long totalSpace = file.getTotalSpace();
        long usableSpace = file.getUsableSpace();
        return (usableSpace / totalSpace) * 100;
    }
}
