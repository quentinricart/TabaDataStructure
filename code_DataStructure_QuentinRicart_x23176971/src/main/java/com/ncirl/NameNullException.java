package com.ncirl;

// Custom exception class for representing a situation where a name is null
public class NameNullException extends RuntimeException {

    // Constructor with a message parameter
    public NameNullException(String message) {
        // Call the superclass constructor with the provided message
        super(message);
    }

}
