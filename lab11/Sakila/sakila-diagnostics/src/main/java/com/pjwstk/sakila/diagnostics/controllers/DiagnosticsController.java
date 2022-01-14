package com.pjwstk.sakila.diagnostics.controllers;

import com.pjwstk.sakila.diagnostics.selftests.DiskStorageSelfTest;
import com.pjwstk.sakila.diagnostics.selftests.SelftestRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController  {

    @GetMapping("status")
    public ResponseEntity isAlive(){
        return ResponseEntity.ok("ALIVE");
    }


    @GetMapping("selftest")
    public ResponseEntity selfTest(SelftestRunner selftestRunner){
        return ResponseEntity.ok(selftestRunner.run());
    }

}
