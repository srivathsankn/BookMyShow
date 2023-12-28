package com.srilearning.BookMyShow.Services;

import com.srilearning.BookMyShow.Exceptions.SeatNotAvailableException;
import com.srilearning.BookMyShow.Exceptions.UserNotAvailableException;
import com.srilearning.BookMyShow.Models.*;

import com.srilearning.BookMyShow.Repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class TicketService  {
    UserService userService;
    ShowSeatService showSeatService;
    TicketRepo ticketRepo;

    @Autowired
    public TicketService(UserService userService, ShowSeatService showSeatService, TicketRepo ticketRepo)
    {
        this.userService = userService;
        this.showSeatService = showSeatService;
        this.ticketRepo = ticketRepo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket getTicket(long userId, List<Long> showSeatIds) throws UserNotAvailableException, SeatNotAvailableException {
        // get User Object from userService
        User user = userService.getUser(userId);
        //check for ShowSeat availability and lock them.
        List<ShowSeat> showSeats = showSeatService.getShowSeats(showSeatIds);
        for (ShowSeat showSeat: showSeats)
        {
            if (showSeat.getStatus() != BookingStatus.AVAILABLE)
                throw new SeatNotAvailableException(showSeat.getId());
        }
        showSeats = showSeatService.getShowSeatsWithLock(showSeatIds);
        for (ShowSeat showSeat: showSeats)
        {
            if (showSeat.getStatus() != BookingStatus.AVAILABLE)
                throw new SeatNotAvailableException(showSeat.getId());
            else {
                showSeat.setStatus(BookingStatus.LOCKED);
                showSeat.setLockedTime(new Date());
            }
        }

        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatus.LOCKED);
        ticket.setSeats(showSeats);
        ticket.setBookedBy(user);

        return ticketRepo.save(ticket);

    }
}
