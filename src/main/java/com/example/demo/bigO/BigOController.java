package com.example.demo.bigO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BigOController {

    @GetMapping("/constant")
    public String constantTimeOperation()
    {
        return "This is a constant time operation.";
    }

    @GetMapping("/linear/{n}")
    public String linearTime(@PathVariable int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return "This is a linear time operation.";
    }

    @GetMapping("/quadratic/{n}")
    public String quadraticTime(@PathVariable int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = i + j;
            }
        }
        return "This is a quadratic time operation.";
    }
}