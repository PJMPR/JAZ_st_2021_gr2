package com.pjwstk.sakila.diagnostics.selfTest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelfTestRunner {
    public List<SelfTestExecute> getSelfTestList() {
        return selfTestList;
    }

    public void setSelfTestList(List<SelfTestExecute> selfTestList) {
        this.selfTestList = selfTestList;
    }

    List<SelfTestExecute> selfTestList;

    public List<SelfTestResult> run() {
        List<SelfTestResult> resultList = new ArrayList<>();
        selfTestList.forEach(selfTest -> resultList.add(selfTest.execute()));
        return resultList;
    }
}

