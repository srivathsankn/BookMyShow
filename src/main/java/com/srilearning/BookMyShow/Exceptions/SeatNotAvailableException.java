package com.srilearning.BookMyShow.Exceptions;

public class SeatNotAvailableException extends Exception {

    public SeatNotAvailableException(long id) {
        super ("SeatId : " + id + " is not available to book.");
    }
}
