package com.example.demo.quartz.schedule;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class ScheduleInfo implements Serializable {
    private int fireCount;
    private int repeatInterval;
    private int startHour;
    
    private boolean infRun;

    public int getFireCount() {
        return fireCount;
    }

    public void setFireCount(int totalFireCount) {
        this.fireCount = totalFireCount;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(int repeatIntervalHs) {
        this.repeatInterval = repeatInterval;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
}