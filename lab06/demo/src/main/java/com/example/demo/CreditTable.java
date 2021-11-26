package com.example.demo;


import javax.persistence.*;
import java.beans.IntrospectionException;

@Entity
@Table(name="credittable")
public class CreditTable {

    private Integer number;
    private double capital;
    private double interest;
    private double fixed_fee;
    private double capital_to_pay;
    private double amount;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer nunber) {
        this.number = nunber;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getFixed_fee() {
        return fixed_fee;
    }

    public void setFixed_fee(double fixed_fee) {
        this.fixed_fee = fixed_fee;
    }

    public double getCapital_to_pay() {
        return capital_to_pay;
    }

    public void setCapital_to_pay(double capital_to_pay) {
        this.capital_to_pay = capital_to_pay;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "CreditTable{" +
                "number=" + number +
                ", capital=" + capital +
                ", interest=" + interest +
                ", fixed_fee=" + fixed_fee +
                ", capital_to_pay=" + capital_to_pay +
                ", amount=" + amount +
                '}';
    }
}
