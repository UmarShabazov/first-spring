package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping ("/greeting")
    public String greeting () {

        return "Hello, world!";

    }

    @GetMapping("/greeting/{username}")
    public String userGreeting (@PathVariable String username) {

        return "Hello, " + username + "!";
    }

//http://www.google.com:433/path/
}
