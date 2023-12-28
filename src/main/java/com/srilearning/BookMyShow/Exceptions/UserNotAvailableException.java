package com.srilearning.BookMyShow.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserNotAvailableException extends Exception {
    private String message;
    public UserNotAvailableException(long userId)
    {
        super("UserID " + userId + " Not Found. Only Registered user can book ticket");
        message = "UserID " + userId + " Not Found. Only Registered user can book ticket";
    }


}
