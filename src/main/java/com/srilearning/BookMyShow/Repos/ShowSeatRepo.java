package com.srilearning.BookMyShow.Repos;

import com.srilearning.BookMyShow.Models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    default public List<ShowSeat> findAllByIdWithLock(List<Long> showSeatIds)
    {
        return findAllById(showSeatIds);
    }
}
