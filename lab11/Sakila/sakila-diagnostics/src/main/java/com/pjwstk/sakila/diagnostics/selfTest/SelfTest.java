package com.pjwstk.sakila.diagnostics.selfTest;

public abstract class SelfTest implements SelfTestExecute {
    public String name;
    public String text;
    abstract public SelfTestResult execute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String description) {
        this.text = text;
    }

}

