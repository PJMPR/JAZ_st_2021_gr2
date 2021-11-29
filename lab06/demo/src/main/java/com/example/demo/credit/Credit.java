package com.example.demo.credit;

import com.example.demo.timetable.Timetable;

import java.util.ArrayList;
import java.util.List;

public abstract class Credit {
    List<Timetable> timetableList = new ArrayList<>();
    int amount;
    int installmentCount;
    double percentage;
    double fixedRate;
    double capitalStillToPay;
    double capitalAlreadyPaid;

    public Credit(int amount, int installmentCount, double percentage, double fixedRate) {
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
    }
}