package com.srilearning.BookMyShow.Services;

import com.srilearning.BookMyShow.Models.Actor;
import com.srilearning.BookMyShow.Repos.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ActorService {
    ActorRepo actorRepo;

    @Autowired
    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public Actor addActor( String actorName)
    {
        return actorRepo.save(new Actor(0, actorName));
    }
}
