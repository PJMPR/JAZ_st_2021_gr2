package jaz.lab06.demo.LoanRepaymentSchedule.Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LoanSubmission")
public class LoanSubmission extends MappedModel{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private int amount;
    private int installmentCount;
    private int fixedRate;
    private double percentage;
    @Enumerated(EnumType.STRING)
    private InstallmentType installmentType;

    public LoanSubmission() {

    }

    @OneToMany(mappedBy = "loanSubmission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Schedule> schedules;
    //private Set<Schedule> scheduleSet = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public int getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(int fixedRate) {
        this.fixedRate = fixedRate;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }
}
