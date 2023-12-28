package com.srilearning.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;

    @ManyToOne
    private City city;

    @OneToMany
    private List<Audi> audis;

    @Enumerated(EnumType.ORDINAL)
    private TheatreStatus Status;

//    @OneToMany(mappedBy="Show")
//    private List<Show> shows;
}
