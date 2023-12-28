package com.srilearning.BookMyShow.Repos;

import com.srilearning.BookMyShow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {


}
