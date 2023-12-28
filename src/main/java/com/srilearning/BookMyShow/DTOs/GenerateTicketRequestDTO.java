package com.srilearning.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenerateTicketRequestDTO {
    private long UserId;
    private List<Long> showSeatIds;
}
