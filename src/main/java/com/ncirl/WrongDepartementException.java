package com.ncirl;

// Custom exception class for representing a situation where a departement is not in the list
public class WrongDepartementException extends RuntimeException{

    // Constructor with a message parameter
    public WrongDepartementException(String message){
        // Call the superclass constructor with the provided message
        super(message);
    }

}
