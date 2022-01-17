package com.pjwstk.sakila.diagnostics.controllers;
import com.pjwstk.sakila.diagnostics.selfTest.DiskStorageTest;
import com.pjwstk.sakila.diagnostics.selfTest.SelfTestRunner;
import com.pjwstk.sakila.reports.selfTest.DbConnectionTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;


@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController {

    @GetMapping("status")
    public ResponseEntity isAlive(){
        return ResponseEntity.ok("ALIVE");
    }

    
    //mapping for whole setTest execution
    @GetMapping("selftest")
    public ResponseEntity selfTest(){
        SelfTestRunner selfTestRunner = new SelfTestRunner();
        selfTestRunner.setSelfTestList(Arrays.asList(
                new DbConnectionTest(),
                new com.pjwstk.sakila.reports.selfTest.DbConnectionTest(),
                new DiskStorageTest()));
        return ResponseEntity.ok(selfTestRunner.run());
    }

}
