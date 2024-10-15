package com.example.demo.bigO;

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


}