package com.java.streams.numbers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    public List<Integer> generateIntStream(int size, int lowerLimit, int upperLimit) {
        return new Random().ints(size, lowerLimit, upperLimit)
                .boxed()
                .collect(Collectors.toList());
    }

    public void printList(List<Integer> list) {
        list.forEach(s -> System.out.print(s + " | "));
    }

    public int getMinInt(List<Integer> list) {
        return list.stream()
                        .min(Integer::compareTo)
                        .get();
    }

    public int getMaxInt(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .get();
    }

    public List<Integer> getMultiplesOfNum(List<Integer> list, int num) {
        return list.stream()
                        .filter(p -> p % num == 0)
                        .collect(Collectors.toList());
    }

    public List<Integer> addNum(List<Integer> list, int num) {
        return list.stream()
                .map(p -> p + num)
                .collect(Collectors.toList());
    }
}
