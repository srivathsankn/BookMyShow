package com.srilearning.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Language> languages;

    @ManyToMany
    private List<Actor> cast;

    private double imDBRating;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genres;

    private double duration;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
