package com.srilearning.BookMyShow.Services;

import com.srilearning.BookMyShow.Exceptions.UserNotAvailableException;
import com.srilearning.BookMyShow.Models.User;
import com.srilearning.BookMyShow.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(long userId) throws UserNotAvailableException {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty())
            throw new UserNotAvailableException(userId);
        return userOptional.get();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
