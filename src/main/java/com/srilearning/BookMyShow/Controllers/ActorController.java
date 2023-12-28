package com.srilearning.BookMyShow.Controllers;

import com.srilearning.BookMyShow.Models.Actor;
import com.srilearning.BookMyShow.Services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor actor)
    {
        return actorService.addActor(actor.getName());
    }
}
