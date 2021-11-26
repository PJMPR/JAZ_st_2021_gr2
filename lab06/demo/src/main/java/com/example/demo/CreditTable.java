package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "credittable")
public class CreditTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    private double capital;
    private double interest;
    private double fixed_fee;
    private double capital_to_pay;
    private double amount;

    Integer getNumber() {
        return number;
    }

    void setNumber(final Integer number) {
        this.number = number;
    }

    double getCapital() {
        return capital;
    }

    void setCapital(final double capital) {
        this.capital = capital;
    }

    double getInterest() {
        return interest;
    }

    void setInterest(final double interest) {
        this.interest = interest;
    }

    double getFixedFee() {
        return fixed_fee;
    }

    void setFixedFee(final double fixedFee) {
        this.fixed_fee = fixedFee;
    }

    double getCapitalToPay() {
        return capital_to_pay;
    }

    void setCapitalToPay(final double capitalToPay) {
        this.capital_to_pay = capitalToPay;
    }

    double getAmount() {
        return amount;
    }

    void setAmount(final double amount) {
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
