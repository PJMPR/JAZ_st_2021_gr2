package com.pjwstk.sakila.diagnostics.selfTest;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiskStorageTest extends SelfTest{
    private static final int minDiskCapacity = 5;

    public DiskStorageTest() {
        name = "DiskStorageTest";
        text = "Is 5% disk space available...";
    }

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult selftestResult = new SelfTestResult(name, text, false, errors);

        if(getUsableDiscSpacePercentage() >= diskCapacity) selftestResult.setPassed(true);
        else {
            selftestResult.setPassed(false);
            errors.add(String.format("Disk space ERROR! Out of required %d percent, got %x percent.", minDiskCapacity, getUsableDiscSpacePercentage()));
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
