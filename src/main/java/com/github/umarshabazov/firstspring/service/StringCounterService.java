package com.github.umarshabazov.firstspring.service;

import java.util.List;


/**
 * collects strings and counts the amount of the repetition of such strings
 */
public interface StringCounterService {

    /**
     * saves string, on repeatable enter of the same string keeps the count of input strings
     *
     * @param value - any string, not null
     */
    void add(String value);

    /**
     *
     * @param count - any positive int
     * @return most frequent strings according to the count
     */
    List<String> top (int count);

}
