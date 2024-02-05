package com.github.umarshabazov.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//новый контроллер:
//
//        - В контроллере нужно завести поле - список чисел.
//- /calculator/memory/list - возвращает содержимое этого списка
//
//- /calculator/memory/save?number=<double value>
//запоминает число в список.
//
//- /calculator/memory/reset - очищает список запомненных чисел
//
//- /calculator/memory/avg - возвращает среднее арифметическое всех чисел в памяти
//
//- /calculator/memory/sum - возвращает сумму всех числе в списке
//        -
@RestController
@RequestMapping("/calculator/memory")
public class NumbersController {

    public List<Double> list = new ArrayList<>();

    @GetMapping("/list")
    public List<Double> memoryList() {

        return list;
    }

    @GetMapping("/save")
    public void saveList(@RequestParam double number) {

        list.add(number);
    }

    @GetMapping("/reset")
    public void resetList() {
        list.clear();
    }

    @GetMapping("/avg")
    public double avgList() {

        double flow = 0;

        for (int i = 0; i < list.size(); i++) {
            flow += list.get(i);
        }
        return flow / list.size();
    }

    @GetMapping("/sum")
    public double sumList() {

        double flow = 0;

        for (int i = 0; i < list.size(); i++) {
            flow += list.get(i);
        }
        return flow;

    }
}
