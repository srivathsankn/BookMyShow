package com.srilearning.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter
public class Actor extends BaseModel {
    private String name;

    @ManyToMany
    private List<Movie> movies;

    public Actor()
    {

    }
    public Actor(String actorName) {
        this.name = actorName;
    }

    public Actor(int i, String actorName) {
        super();
        this.setId(i);
        this.setName(actorName);
    }
}
