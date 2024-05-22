package com.ncirl;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree implements BTInterface{

    public BTNode theRoot;

    public BinaryTree() {
        // Initialize an empty tree
        theRoot = null; 
    }

    // Method to insert a node
    @Override
    public void insertEmployee(BTNode newNode) {

        if (newNode == null) {
            throw new IllegalArgumentException("Cannot insert a null node.");
        }
        helperInsertNode(theRoot, newNode);
    }

    // Helper method to recursively insert a node into the binary tree
    private void helperInsertNode(BTNode startNode, BTNode newNode) {

        if (theRoot == null) {
            // If the tree is empty, the new node becomes the root
            theRoot = newNode; 
        } 
        else {
            // Compare the new node with the current node and traverse accordingly
            if (newNode.getElement().compareTo(startNode.getElement()) > 0) {
                if (startNode.getRightChild() == null) {
                    // Insert to the right if right child is null
                    startNode.setRightChild(newNode); 
                } 
                else {
                    // Recursively traverse right subtree
                    helperInsertNode(startNode.getRightChild(), newNode); 
                }
            } 
            else if (newNode.getElement().compareTo(startNode.getElement()) < 0) {
                if (startNode.getLeftChild() == null) {
                    // Insert to the left if left child is null
                    startNode.setLeftChild(newNode); 
                } 
                else {
                    // Recursively traverse left subtree
                    helperInsertNode(startNode.getLeftChild(), newNode); 
                }
            } 
            else {
                // If we find a node with the same id we do not insert it
                System.out.println("The node " + startNode.getElement() + " was already inserted.");
            }
        }
    }


    //  Searches for a node with a specific ID in the binary tree    
    @Override
    public BTNode searchEmployee(int id) {
        return helperSearch(id, theRoot);
    }

    // Helper method to recursively search for a node with a specific ID
    private BTNode helperSearch(int id, BTNode startNode) {
        if (startNode == null) {
            // If the start node is null, we stop as there is no children
            return null; 
        } 
        else {
            int comparison = id - startNode.getElement().getId();
            if (comparison == 0) {
                // Found the node with the specified ID
                return startNode; 
            } 
            else if (comparison < 0) {
                // Search left subtree
                return helperSearch(id, startNode.getLeftChild()); 
            } 
            else {
                // Search right subtree
                return helperSearch(id, startNode.getRightChild()); 
            }
        }
    }

   
    //Prints all elements of the binary tree in natural order
    @Override     
    public void printAllEmployeeInIDOrder() {
        helperInOrderTraversal(theRoot);
    }

    // Helper method to perform in-order traversal and print elements
    private void helperInOrderTraversal(BTNode node) {
        if (node != null) {
            // Traverse left subtree
            helperInOrderTraversal(node.getLeftChild());
            // Print current node
            System.out.println("Node: " + node.getElement());
            // Traverse right subtree
            helperInOrderTraversal(node.getRightChild());
        }
    }

    
    //Deletes a node with a specific ID from the binary tree 
    @Override   
    public void deleteEmployeeFromID(int id) {
        // Create a list to store all children of the node to be deleted
        List<BTNode> listAllChildren = new ArrayList<>();

        // Search for the node with the specified ID in the binary tree
        BTNode nodeToDelete = searchEmployee(id);
        // If the node is not found, print a message and return without performing any further action
        if (nodeToDelete == null) {
            System.out.println("No node with this ID to delete.\n");
            return;
        }
        
        // Add all children of the node to be deleted to the list
        addAllChildrenToAList(nodeToDelete, listAllChildren);
        
        // Remove the link from the parent of the node to be deleted
        setParentLinkToNull(theRoot, nodeToDelete);
        
        // Re-insert all children into the tree after setting their children to null
        listAllChildren.forEach(child -> {
            child.setLeftChild(null);
            child.setRightChild(null);
        });
        listAllChildren.forEach(child -> insertEmployee(child));
    }

    // Helper method to add all children of a node to a list
    private void addAllChildrenToAList(BTNode node, List<BTNode> list) {
        // If the left child of the current node is not null, add it to the list and recursively traverse its subtree
        if (node.getLeftChild() != null) {
            list.add(node.getLeftChild());
            // Recursively traverse left subtree
            addAllChildrenToAList(node.getLeftChild(), list);
        }
        // If the right child of the current node is not null, add it to the list and recursively traverse its subtree
        if (node.getRightChild() != null) {
            list.add(node.getRightChild());
            // Recursively traverse right subtree
            addAllChildrenToAList(node.getRightChild(), list);
        }
    }

    // Helper method to set the parent link to null for a given node
    private void setParentLinkToNull(BTNode parent, BTNode node) {

        // If either the parent or the node is null, no action is needed
        if (parent == null || node == null) {
            return; // Parent or node is null, no action needed
        }

         // If the left child of the parent is the node to be deleted, set the left child link to null
        if (parent.getLeftChild() == node) {
            parent.setLeftChild(null); // Set link from parent to null if node is left child
        }

        // If the right child of the parent is the node to be deleted, set the right child link to null
        if (parent.getRightChild() == node) {
            parent.setRightChild(null); // Set link from parent to null if node is right child
        }

        // Recursively search only in the subtree where the node could potentially be
        if (node.getElement().compareTo(parent.getElement()) < 0) {
            // Search in the left subtree
            setParentLinkToNull(parent.getLeftChild(), node); 
        } else {
            // Search in the right subtree
            setParentLinkToNull(parent.getRightChild(), node); 
        }
    }
}