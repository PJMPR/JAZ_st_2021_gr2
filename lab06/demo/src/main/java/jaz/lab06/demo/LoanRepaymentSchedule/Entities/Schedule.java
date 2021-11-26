package jaz.lab06.demo.LoanRepaymentSchedule.Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Schedule")
public class Schedule extends MappedModel{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    //@Column(insertable = false, updatable = false)
    private long id;
    private int installment;
    private double capital;
    private double interest;
    private double fixedFee;
    private double capitalToPay;
    private double amount;

    public Schedule(){

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, unique = true)
    private LoanSubmission loanSubmission;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
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

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public double getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(double capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
