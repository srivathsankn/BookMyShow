package com.srilearning.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {

    @OneToMany
    private List<ShowSeat> seats;

    @ManyToOne
    private User BookedBy;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    @Override
    public String toString() {
        return "Ticket{" +
                "seats=" + seats +
                ", BookedBy=" + BookedBy +
                ", status=" + status +
                ", payments=" + payments +
                '}';
    }
}
