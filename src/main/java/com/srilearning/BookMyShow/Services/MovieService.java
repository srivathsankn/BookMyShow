package com.srilearning.BookMyShow.Services;

import com.srilearning.BookMyShow.Models.Movie;
import com.srilearning.BookMyShow.Repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie saveMovie(Movie movie)
    {
        movie.setId(0);
        //The below will need to preceded by the code to build Movie object.
        // movie object cannot be passed by the controller (via postmnan)
        return movieRepo.save(movie);
    }
}
