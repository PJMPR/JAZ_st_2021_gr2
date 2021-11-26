package com.example.jazlab06.credit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credit {
    @Id
    private long id;
    private double amount;
    private int installmentCount;
    private String installmentType;
    private double percentage;
    private double fixedRate;
    public  double capital;
    public double interest;
    public double fixedFee;
    public double capitalToPay;
    public Credit(long id, double amount, int installmentCount, String installmentType, double percentage, double fixedRate, double capital, double interest,
                  double fixedFee, double capitalToPay){
        this.id = id;
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.installmentType = installmentType;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
        this.capital = capital;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.capitalToPay = capitalToPay;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getAmount(){
            return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public  int getInstallmentCount(){
        return installmentCount;
    }
    public void setInstallmentCount(int installmentCount){
        this.installmentCount = installmentCount;
    }
    public String getInstallmentType(){
        return installmentType;
    }
    public void setInstallmentType(String installmentType){
        this.installmentType = installmentType;
    }
    public double getPercentage(){
        return percentage;
    }
    public void setPercentage(double percentage){
        this.percentage = percentage;
    }
    public double getFixedRate(){
        return fixedRate;
    }
    public void setFixedRate(double fixedRate){
        this.fixedRate = fixedRate;
    }
}
