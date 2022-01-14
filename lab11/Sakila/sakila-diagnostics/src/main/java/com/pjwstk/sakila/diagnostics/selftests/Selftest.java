package com.pjwstk.sakila.diagnostics.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;



public interface Selftest {
    SelfTestResult execute() throws Exception;
}
