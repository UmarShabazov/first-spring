package com.github.umarshabazov.firstspring.controller;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SegTestController {

    public HashMap<String, Integer> url = new HashMap<>();

    @GetMapping("/add/{anyName}")
    public void addUrl(@PathVariable String anyName) {

        if (url.containsKey(anyName)) {
            url.put(anyName, url.get(anyName) + 1);
        } else {
            url.put(anyName, 1);
        }
    }


    @GetMapping("/top/{anyInteger}")
    public String[] getUrl(@PathVariable Integer anyInteger) {

        List<Integer> values = new ArrayList<>(url.values());
        Integer[] arr = new Integer[values.size()];
        values.toArray(arr);
        String[] strings = new String[anyInteger];

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] < arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        if (anyInteger > 0) {

            for (Map.Entry<String, Integer> stringIntegerEntry : url.entrySet()) {

                for (int k = 0; k < anyInteger; k++) {
                    if (stringIntegerEntry.getValue().equals(arr[k])) {
                        strings[k] = stringIntegerEntry.getKey();
                    }
                }
            }


        }
        return strings;
    }
}
