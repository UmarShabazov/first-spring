package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SegTestController {

    public List <String> url = new ArrayList<>();

    @GetMapping ("/add/{anyUrl}")
    public void addUrl (@PathVariable String anyUrl) {

        url.add(anyUrl);
    }


    @GetMapping ("/top/{integer}")
    public List <String> getUrl (@PathVariable int integer) {

        return Collections.singletonList(url.get(0));
        //Должен возвращать самые популярные домены, пока оставлю по индексу, надо доработать
    }
}
