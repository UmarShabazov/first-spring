package com.github.umarshabazov.firstspring.controller;

import com.github.umarshabazov.firstspring.service.InMemoryStringCounterServiceImpl;
import com.github.umarshabazov.firstspring.service.StringCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class NameCounterController {

    public HashMap<String, Integer> url = new HashMap<>();
    StringCounterService stringCounterService = new InMemoryStringCounterServiceImpl();


    @GetMapping("/add/{anyName}")
    public void addUrl(@PathVariable String anyName) {

        stringCounterService.add(anyName);
    }

    @GetMapping("/top/{anyInteger}")
    public List <String> getUrl(@PathVariable Integer anyInteger) {

        return stringCounterService.top(anyInteger);
    }
}
