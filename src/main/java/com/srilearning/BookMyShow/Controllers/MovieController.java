package com.srilearning.BookMyShow.Controllers;

import com.srilearning.BookMyShow.Models.Movie;
import com.srilearning.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return movieService.saveMovie(movie);
    }

}
