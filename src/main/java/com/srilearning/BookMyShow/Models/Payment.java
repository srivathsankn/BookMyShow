package com.srilearning.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;

}
