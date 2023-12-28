package com.srilearning.BookMyShow.Services;

import com.srilearning.BookMyShow.Models.ShowSeat;
import com.srilearning.BookMyShow.Repos.ShowSeatRepo;
import jakarta.persistence.LockModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {
    private ShowSeatRepo showSeatRepo;

    @Autowired
    public ShowSeatService(ShowSeatRepo showSeatRepo) {
        this.showSeatRepo = showSeatRepo;
    }

    public List<ShowSeat> getShowSeats(List<Long> showSeatIds) {
        return showSeatRepo.findAllById(showSeatIds);
    }

    public List<ShowSeat> getShowSeatsWithLock(List<Long> showSeatIds) {
        return showSeatRepo.findAllByIdWithLock(showSeatIds);
    }
}
