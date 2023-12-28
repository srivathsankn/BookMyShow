package com.srilearning.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "Seats")
public class Seat extends BaseModel {
    private int rowNum;
    private  int colNum;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
