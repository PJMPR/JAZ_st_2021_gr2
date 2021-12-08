package com.example.demo.DTOStrategy;

import java.math.BigDecimal;

public class PaymentDTO {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}