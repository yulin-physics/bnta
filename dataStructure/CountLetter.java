package com.yulin.bnta.dataStructure;

import java.util.HashMap;
import java.util.Map;

public class CountLetter {
    public static Map letterString(String string){
        Map<String, Integer> map = new HashMap();
        String[] letters = string.split(",");

        for (String letter:letters){
            boolean hasKey = map.containsKey(letter);

            if(hasKey){
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        return map;

    }
}
