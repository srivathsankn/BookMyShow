package com.srilearning.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Audi extends BaseModel {
    String name;
    Integer totalRows;
    Integer totalCols;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<Feature> features;

    @OneToMany
    List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    AudiStatus status;
}
