package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Integer[] arr = values.toArray(new Integer[0]);
        String[] results = new String[anyInteger];


        for (int i = 0; i < values.size() - 1; i++) {
            int minIndex = i;
            for (int j = i; j < values.size(); j++) {
                if (values.get(minIndex) < values.get(j)) {
                    minIndex = j;
                }
            }
            int tmp = values.get(i);
            values.set(i, values.get(minIndex));
            values.set(minIndex, tmp);

        }

        if (anyInteger > 0) {

            for (Map.Entry<String, Integer> name2Count : url.entrySet()) {

                for (int k = 0; k < anyInteger; k++) {
                    if (name2Count.getValue().equals(values.get(k))) {
                        results[k] = name2Count.getKey();
                    }
                }
            }

        }
        return results;
    }
}
