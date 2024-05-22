package com.ncirl;

public interface BTInterface {

    //Method to insert an Employee
    public void insertEmployee(BTNode newNode);

    //Method to search an Employee based on the id
    public BTNode searchEmployee(int id);

    //method to  print details of each record based on the numerical sequence of their employee ID
    public void printAllEmployeeInIDOrder();

    //Method to delete an Employee based on the ID
    public void deleteEmployeeFromID(int id);

}
