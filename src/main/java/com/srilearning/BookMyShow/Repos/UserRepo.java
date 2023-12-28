package com.srilearning.BookMyShow.Repos;

import com.srilearning.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findById(long userId);

//    public List<User> findAllByIdEmpty();
}
