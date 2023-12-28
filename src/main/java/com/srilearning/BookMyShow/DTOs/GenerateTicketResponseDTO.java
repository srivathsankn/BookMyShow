package com.srilearning.BookMyShow.DTOs;

import com.srilearning.BookMyShow.Models.ResponseStatus;
import com.srilearning.BookMyShow.Models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketResponseDTO {
    Ticket ticket;
    ResponseStatus responseStatus;
}
