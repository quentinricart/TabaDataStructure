package com.ncirl;

import java.time.LocalDate;

// Employee class representing an employee entity
public class Employee implements Comparable<Employee>{

    // Fields to store employee information
    private String firstName;  
    private String lastName;   
    private int id;           
    private LocalDate birthDate;  
    private String departement;

    public Employee(String firstName, String lastName, int id,String departement, LocalDate birthDate) {
        // Validation checks for first name, last name, departement and id
        if(firstName == null){
            throw new NameNullException("The first name must contain a value");
        }
        if(lastName == null){
            throw new NameNullException("The last name must contain a value");
        }
        if(id < 1000 || id > 9999){
            throw new WrongIDException("The id must be a number between 1000 and 9999");
        }
        if(departement == null){
                throw new WrongDepartementException("The departement cannot be null");
        }

        if(!departement.equals("Development") && !departement.equals("HR") 
            && !departement.equals("Sales") && !departement.equals("Finance")){
                throw new WrongDepartementException("The correct list of departement is Development, HR, Sales, Finance");
        }

        
        // Initialize fields
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.departement = departement;
        this.birthDate = birthDate;
        
    }

    // Constructor without birth date
    public Employee(String firstName, String lastName, int id, String departement) {        
        this(firstName, lastName, id, departement, null);        
    }

    // Getter and setter methods for employee fields

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for employee ID
    public int getId() {
        return id;
    }

    // Getter for birth date
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setter for departement
    public String getDepartement() {
        return departement;
    }

    // Getter for departement
    public void setDepartement(String departement) {
        this.departement = departement;
    }

    // Setter for birth date
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Implement compareTo method for natural ordering based on the ID
    @Override
    public int compareTo(Employee other){
        return this.id - other.id;
    }

    // Override toString method for better readability
    @Override
    public String toString(){
        // Check if the birth date is null
        if(this.getBirthDate() == null){
            // If birth date is null, return string representation without birth date
            return "Employee ID: " + id + ", Name: " + firstName + " " + lastName + ", Departement: " + departement;
        }
        else{
            // If birth date is not null, return string representation with birth date
            return "Employee ID: " + id + ", Name: " + firstName + " " + lastName + ", Departement: " + departement + ", Birth Date: " + birthDate;
        }
    }

    // Note about not providing a setter for id
    // As mentioned, the ID value cannot be changed once an employee object is created.
    // Hence, no setter method is provided for the id field.
    // It's important to ensure the uniqueness and integrity of employee IDs.
}