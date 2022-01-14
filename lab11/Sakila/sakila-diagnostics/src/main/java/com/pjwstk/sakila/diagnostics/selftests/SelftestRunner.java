package com.pjwstk.sakila.diagnostics.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;


import java.util.ArrayList;



@Component
public class SelftestRunner {
    @Autowired
    List<Selftest> selftests;

    public List<SelfTestResult> run(){
        List<SelfTestResult> selfTestResults = new ArrayList<>();
        selftests.forEach(selfTest -> {
            try {
                selfTestResults.add(selfTest.execute());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return selfTestResults;
    }
}
