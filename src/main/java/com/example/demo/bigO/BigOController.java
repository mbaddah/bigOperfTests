package com.example.demo.bigO;

import com.example.demo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigOController {

    @GetMapping("/constant")
    public String constantTimeOperation()
    {
        return "This is a constant O(1) time operation. E.g. Looking up item in a hash map, retrieve value from dictionary etc...";
    }

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("John Doe", 30, "123 Main St", "john.doe@gmail.com");
    }

    @GetMapping("/linear/{n}")
    public String linearTime(@PathVariable int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return "This is a linear time operation. E.g. Looping through an array, list etc... summing up all elements in an array etc...";
    }

    @GetMapping("/quadratic/{n}")
    public String quadraticTime(@PathVariable int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = i + j;
            }
        }
        return "This is a quadratic time operation. Like a naive implementation of bubble sort. E.g. Nested loops, bubble sort etc...";
    }

    @GetMapping("/logarithmic/{n}/{target}")
    public String logarithmicTime(@PathVariable int n, @PathVariable int target) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return "Target found. This is a logarithmic time operation. E.g. Binary search, divide and conquer etc...";
            }

            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return "Target not found";

    }

    @GetMapping("/heapSort/{n}")
    public String heapSort(@PathVariable int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        int length = array.length;

        // Build heap
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        // One by one extract an element from heap
        for (int i = length - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }

        return "Array sorted using Heap Sort. This is a linearithmic time operation.";
    }

    private void heapify(int[] array, int length, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // If left child is larger than root
        if (leftChild < length && array[leftChild] > array[largest])
            largest = leftChild;

        // If right child is larger than largest so far
        if (rightChild < length && array[rightChild] > array[largest])
            largest = rightChild;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, length, largest);
        }
    }
}