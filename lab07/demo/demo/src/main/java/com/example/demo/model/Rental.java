package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
    private int rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;
    private Collection<Payment> paymentsByRentalId;
    private Customer customer;

    @Id
    @Column(name = "rental_id")
    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    @Basic
    @Column(name = "rental_date")
    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Basic
    @Column(name = "return_date")
    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (rentalId != rental.rentalId) return false;
        if (!Objects.equals(rentalDate, rental.rentalDate)) return false;
        if (!Objects.equals(returnDate, rental.returnDate)) return false;
        if (!Objects.equals(lastUpdate, rental.lastUpdate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rentalId;
        result = 31 * result + (rentalDate != null ? rentalDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rental")
    public Collection<Payment> getPaymentsByRentalId() {
        return paymentsByRentalId;
    }

    public void setPaymentsByRentalId(Collection<Payment> paymentsByRentalId) {
        this.paymentsByRentalId = paymentsByRentalId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
