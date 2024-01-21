package com.srilearning.BookMyShow.Controllers;

import com.srilearning.BookMyShow.DTOs.GenerateTicketRequestDTO;
import com.srilearning.BookMyShow.DTOs.GenerateTicketResponseDTO;
import com.srilearning.BookMyShow.Models.ResponseStatus;
import com.srilearning.BookMyShow.Models.Ticket;
import com.srilearning.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    TicketService ticketService;

     @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path="/ticket") // Need to code @RequestBody annotation and make it Post request...
    public @ResponseBody ResponseEntity<GenerateTicketResponseDTO> generateTicket(@RequestBody GenerateTicketRequestDTO generateTicketRequestDTO)
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
        return new ResponseEntity<>(generateTicketResponseDTO, HttpStatus.OK);
    }
}
