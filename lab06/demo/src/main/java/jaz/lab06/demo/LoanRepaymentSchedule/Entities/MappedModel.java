package jaz.lab06.demo.LoanRepaymentSchedule.Entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class MappedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
}
