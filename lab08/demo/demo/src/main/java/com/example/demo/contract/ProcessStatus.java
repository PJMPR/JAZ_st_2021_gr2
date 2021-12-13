package com.example.demo.contract;

//class for checking the usage of process status
public class ProcessStatus{
    private int ramUsage;
    private int execTime;
    
    public int getRamUsage() {
        return ramUsage;
    }
    
    public void setRamUsage(int ramUsage) {
        this.ramUsage = ramUsage;
    }
    
    public int getExecTime() {
        return execTime;
    }
    
    public void setExecTime(int execTime) {
        this.execTime = execTime;
    }
}