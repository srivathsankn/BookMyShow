package com.srilearning.BookMyShow.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.srilearning.BookMyShow.Models.Movie;
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
