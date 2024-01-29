package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculator/sum")
    public int calculator(@RequestParam int a, @RequestParam int b) {

        return a + b;
    }
}