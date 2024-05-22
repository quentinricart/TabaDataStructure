package com.ncirl;

import java.time.LocalDate;

public class BinaryTreeMain {
    public static void main(String[] args) {
        // Testing all wrong input for creating
        Employee test;

        //Testing creating an Employee with wrong id
        System.out.println("Creating an Employee with a wrong id");
        try{
            test = new Employee("Jack", "Sparrow", 1, "Development");
        }
        catch(WrongIDException e){
            System.out.println(e.getMessage() + "\n");
        }

        //Testing creating an Employee with null as a first Name
        System.out.println("Creating an Employee with null as a first Name");
        try{
            test = new Employee(null, "Sparrow", 1000, "Development");
        }
        catch(NameNullException e){
            System.out.println(e.getMessage() + "\n");
        }

        //Testing creating an Employee with null as a last Name
        System.out.println("Creating an Employee with null as a last Name");
        try{
            test = new Employee("Jack", null, 1000, "Development");
        }
        catch(NameNullException e){
            System.out.println(e.getMessage() + "\n");
        }

        //Testing creating an Employee with null as a departement
        System.out.println("Creating an Employee with null as a departement");
        try{
            test = new Employee("Jack", "Sparrow", 1000, null);
        }
        catch(WrongDepartementException e){
            System.out.println(e.getMessage() + "\n");
        }

        //Testing creating an Employee with wrong departement
        System.out.println("Creating an Employee with null as a departement");
        try{
            test = new Employee("Jack", "Sparrow", 1000, "Unknown");
        }
        catch(WrongDepartementException e){
            System.out.println(e.getMessage() + "\n");
        }

        //Creating 10 Employees, 5 with birthdate and 5 without as it is not mandatory
        Employee emp1 = new Employee("John", "Doe", 1020, "Development", LocalDate.of(2004, 5, 4));
        Employee emp2 = new Employee("Jane", "Smith", 1002, "HR", LocalDate.of(1984, 11, 23));
        Employee emp3 = new Employee("Michael", "Johnson", 1003, "Sales", LocalDate.of(1982, 12, 9));
        Employee emp4 = new Employee("Emily", "Brown", 1004, "Finance", LocalDate.of(1986, 11 , 07));
        Employee emp5 = new Employee("David", "Wilson", 1005, "Development", LocalDate.of(1978, 9, 4));
        Employee emp6 = new Employee("Sarah", "Taylor", 1006, "HR");
        Employee emp7 = new Employee("Chris", "Anderson", 1007, "Sales");
        Employee emp8 = new Employee("Emma", "Martinez", 1008, "Finance");
        Employee emp9 = new Employee("James", "Lee", 1009, "Development");
        Employee emp10 = new Employee("Olivia", "Garcia", 1010, "HR");

        // Create a binary tree
        BinaryTree binaryTree = new BinaryTree();

        //Test to insert a null node
        System.out.println("Test to insert a null node");
        try{
            binaryTree.insertEmployee(null);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage() + "\n");            
        }

        // Insert employees into the binary tree
        binaryTree.insertEmployee(new BTNode(emp1));
        binaryTree.insertEmployee(new BTNode(emp2));
        binaryTree.insertEmployee(new BTNode(emp3));
        binaryTree.insertEmployee(new BTNode(emp4));
        binaryTree.insertEmployee(new BTNode(emp5));
        binaryTree.insertEmployee(new BTNode(emp6));
        binaryTree.insertEmployee(new BTNode(emp7));
        binaryTree.insertEmployee(new BTNode(emp8));
        binaryTree.insertEmployee(new BTNode(emp9));
        binaryTree.insertEmployee(new BTNode(emp10));

        // Print all elements in natural order
        System.out.println("All elements in natural order:");
        binaryTree.printAllEmployeeInIDOrder();
        System.out.println();


        //Test to search an employee with an id not in the tree
        int wrongSearchID = 9999;
        System.out.println("Searching for employee with ID " + wrongSearchID + ":");
        BTNode notFoundNode = binaryTree.searchEmployee(wrongSearchID);
        if (notFoundNode != null) {
            System.out.println("Employee found: " + notFoundNode.getElement() + "\n");
        } else {
            System.out.println("Employee not found.\n");
        }

        // Search for an employee by ID
        int searchId = 1006;
        System.out.println("Searching for employee with ID " + searchId + ":");
        BTNode foundNode = binaryTree.searchEmployee(searchId);
        if (foundNode != null) {
            System.out.println("Employee found: " + foundNode.getElement()+ "\n");
        } else {
            System.out.println("Employee not found.\n");
        }
        
        //Test to delete a node who does not exist
        System.out.println("Test to delete a node who does not exist");
        int wrongDeleteId = 9999;
        System.out.println("Deleting employee with ID " + wrongDeleteId + ":");
        binaryTree.deleteEmployeeFromID(wrongDeleteId);
 
    
        // Delete a node by ID
        int deleteId = 1002;
        System.out.println("Deleting employee with ID " + deleteId + ":\n");
        binaryTree.deleteEmployeeFromID(deleteId);
        System.out.println("All elements after deletion:");
        binaryTree.printAllEmployeeInIDOrder();
    }
}
