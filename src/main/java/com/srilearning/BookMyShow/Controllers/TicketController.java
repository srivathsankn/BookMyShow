package com.srilearning.BookMyShow.Controllers;

import com.srilearning.BookMyShow.DTOs.GenerateTicketRequestDTO;
import com.srilearning.BookMyShow.DTOs.GenerateTicketResponseDTO;
import com.srilearning.BookMyShow.Exceptions.UserNotAvailableException;
import com.srilearning.BookMyShow.Models.ResponseStatus;
import com.srilearning.BookMyShow.Models.Ticket;
import com.srilearning.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(path="genTicket")
    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO generateTicketRequestDTO)
    {
        GenerateTicketResponseDTO generateTicketResponseDTO = new GenerateTicketResponseDTO();
        try {

            Ticket ticket = ticketService.getTicket(generateTicketRequestDTO.getUserId(), generateTicketRequestDTO.getShowSeatIds());
            generateTicketResponseDTO.setTicket(ticket);
            generateTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() + " Hence, Ticket cannot be generated");
            generateTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return generateTicketResponseDTO;
    }
}
