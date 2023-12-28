package com.srilearning.BookMyShow.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.srilearning.BookMyShow.Models.Actor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Long> {

}
