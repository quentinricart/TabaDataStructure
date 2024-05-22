package com.ncirl;

// Class representing a node for a binary tree specific to the Employee class
public class BTNode {
    private Employee element;            // Element stored in the node
    private BTNode leftChild;            // Left child node
    private BTNode rightChild;           // Right child node
    
    // Constructor to create a node with the given employee element
    public BTNode(Employee element){
        this.element = element;
        leftChild = null;
        rightChild = null;
    }
    
    // Method to check if the node is a leaf node
    public boolean isLeaf(){
        return (leftChild == null) && (rightChild == null);
    }
    
    // Method to check if the node is an internal node
    public boolean isInternal(){
        return (leftChild != null) || (rightChild != null);
    }
    
    // Method to check if the node is an external node
    public boolean isExternal(){
        return (leftChild != null) && (rightChild != null);
    }

    // Getter method to retrieve the employee stored in the node
    public Employee getElement(){
        return element;
    }
    
    // Getter method to retrieve the left child node
    public BTNode getLeftChild(){
        return leftChild;
    }

    // Setter method to set the left child node
    public void setLeftChild(BTNode leftChild){
        this.leftChild = leftChild;
    }

    // Getter method to retrieve the right child node
    public BTNode getRightChild(){
        return rightChild;
    }

    // Setter method to set the right child node
    public void setRightChild(BTNode rightChild){
        this.rightChild = rightChild;
    }
}