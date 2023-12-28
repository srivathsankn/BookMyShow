package com.srilearning.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;

    public String toString()
    {
        return " User : " + this.getName() + " (" + this.getId() + ")";
    }
}
