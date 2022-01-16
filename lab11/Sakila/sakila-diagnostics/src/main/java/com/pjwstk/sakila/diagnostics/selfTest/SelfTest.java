package com.pjwstk.sakila.diagnostics.selfTest;

public abstract class SelfTest implements SelfTestExecute {
    public String name;
    public String description;
    abstract public SelfTestResult execute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
