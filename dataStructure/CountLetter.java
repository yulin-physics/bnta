package com.yulin.bnta.dataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingInt;

public class CountLetter {
    public static Map letterString(String string){
        Map<String, Integer> map = new HashMap();
        String[] letters = string.split(",");

        for (String letter:letters){
            letter = letter.trim();
            boolean hasKey = map.containsKey(letter);

            if(hasKey){
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        return map;

    }

    public static Map streamLetterString(String string){
//        Map<String, Long> map = Arrays.stream(string.split(","))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> map = Arrays.stream(string.split(","))
                .collect(Collectors.groupingBy(s -> s, summingInt(s -> 1)));

        return map;

    }
}
