package com.ncirl;

public class BinarySearchMainTest {
    public static void main(String[] args) {
        // Input array
        int[] collection = { 72, 12, 23, 5, 2, 16, 8, 91, 38, 56};
        
        // Print original unsorted array
        System.out.println("Array not sorted:");
        printArray(collection);

        // Sort the array
        System.out.println("Sorting the array\n");
        quicksort(collection);

        // Print sorted array
        System.out.println("Array sorted:");
        printArray(collection);

        // Perform binary search for the element 23
        System.out.println("Looking for the element 23\n");
        int index = recursiveBinarySearch(collection, 23);
        
        // Print result of binary search
        if(index == -1){
            System.out.println("The element hasn't been found");
        }
        else{
            System.out.printf("The element has been found at index %d%n", index);
        }
    }

    // Recursive binary search method
    public static int recursiveBinarySearch(int[] collection, int key){
        return helperBinarySearch(collection,key, 0, collection.length - 1);
    }

    // Helper method for recursive binary search
    private static int helperBinarySearch(int[] collection, int key, int low, int high){
        // To stop the recursion if no element found
        if(low > high)
            return -1;
            
        // Calculate middle index
        int middle = (low + high +1) / 2; // Correct calculation of the middle index
        
        // Check if key is found at middle index
        if(key == collection[middle])
            return middle;
        // If key is less than element at middle index, search in left half
        else if(key < collection[middle]){
            // Update high
            high = middle - 1; 
            return helperBinarySearch(collection, key, low, high);
        }
        // If key is greater than element at middle index, search in right half
        else{
            // Update low
            low = middle + 1; 
            return helperBinarySearch(collection, key, low, high);
        }
    }

    // Quicksort method to sort the array
    public static void quicksort(int[] collection){
        helperQuickSort(collection, 0, collection.length - 1);
    }

    // Helper method for quicksort
    private static void helperQuickSort(int[] collection, int low, int high){
        // // To stop the recursion if everything has been sorted
		if (low >= high){
           return;
        }
        else{
            // Partition the array and recursively sort each partition
           int pi = partition(collection, low, high);
           helperQuickSort(collection, low, pi - 1);
           helperQuickSort(collection, pi + 1, high);
		}
    }
    
    // Partition method for quicksort
    private static int partition(int[] collection, int low, int high){
        // Choose pivot element
        int pivot = collection[high]; 
        int i = (low - 1); 
         
        // Iterate through array and move elements smaller than pivot to left of pivot
        for(int j = low; j <= high - 1; j++){
            if (collection[j] < pivot){
                i++; 
                swap(collection, i, j);
            }
        }
        // Move pivot to its correct position
        swap(collection, i + 1, high);
        // Return index of pivot
        return (i + 1); 
    }

    // Swap method to swap two elements in the array
    private static void swap(int[] collection, int i, int j){
        int temp = collection[i];
        collection[i] = collection[j];
        collection[j] = temp;
    }

    // Method to print the elements of the array
    public static void printArray(int[] collection){
        for(int i = 0; i < collection.length; i ++){
            System.out.print(collection[i] + " ");
        }
        System.out.println("\n");
    }   
}