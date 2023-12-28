package com.srilearning.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="shows")
public class Show extends BaseModel {
    private Date showDate;

    @ManyToOne
    private Theatre theatre;

    @ManyToOne
    private Audi audi;

    @ManyToOne
    private Movie movie;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @Enumerated(EnumType.ORDINAL)
    private Language lang;
}
