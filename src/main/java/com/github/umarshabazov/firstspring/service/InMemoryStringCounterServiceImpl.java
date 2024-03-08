package com.github.umarshabazov.firstspring.service;

import java.util.*;

public class InMemoryStringCounterServiceImpl implements StringCounterService {
    public HashMap<String, Integer> counterStorage = new HashMap<>();
    @Override
    public void add(String value) {
        if (counterStorage.containsKey(value)) {
            counterStorage.put(value, counterStorage.get(value) + 1);
        } else {
            counterStorage.put(value, 1);
        }
    }


    @Override
    public List<String> top(int count) {
        List<Integer> values = new ArrayList<>(counterStorage.values());
        Integer[] arr = values.toArray(new Integer[0]);
        String[] results = new String[count];


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

        if (count > 0) {

            for (Map.Entry<String, Integer> name2Count : counterStorage.entrySet()) {

                for (int k = 0; k < count; k++) {
                    if (name2Count.getValue().equals(values.get(k))) {
                        results[k] = name2Count.getKey();
                    }
                }
            }

        }
        return Arrays.asList(results);
    }
}
