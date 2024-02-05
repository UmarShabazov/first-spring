package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculator/sum")
    public int calculatorSum(@RequestParam int a, @RequestParam int b) {

        return a + b;
    }

    @GetMapping("/calculator/mul")
    public int calculatorMul(@RequestParam int a, @RequestParam int b) {

        return a * b;
    }

    @GetMapping("/calculator/div")
    public int calculatorDiv(@RequestParam int a, @RequestParam int b) {

        return a / b;
    }

    @GetMapping("/calculator/sub")
    public int calculatorSub(@RequestParam int a, @RequestParam int b) {

        return a - b;
    }

}