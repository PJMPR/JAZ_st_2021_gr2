package com.pjwstk.sakila.diagnostics.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public abstract class SelftestBase implements Selftest {
    private String name;
    private String description;
    public abstract SelfTestResult execute() throws Exception;
}
