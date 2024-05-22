package com.ncirl;

// Custom exception class for representing a situation where an ID is outside the valid range
public class WrongIDException extends RuntimeException {

    // Constructor with a message parameter
    public WrongIDException(String message) {
        // Call the superclass constructor with the provided message
        super(message);
    }

}