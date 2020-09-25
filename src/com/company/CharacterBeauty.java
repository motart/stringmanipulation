package com.company;

import java.util.*;

public class CharacterBeauty {
    public static int getBeauty(String input) {
        // Build count
        Map<Character,Integer> charCount = new HashMap<>();
        for (Character character : input.toLowerCase().toCharArray()) {
            charCount.merge(character, 1, Integer::sum);
        }

        // Sort based on count
        List<Integer> list = new ArrayList<>();
        charCount.forEach((key, value) -> list.add(value));
        list.sort(Collections.reverseOrder());

        // Convert sorted counts to weights based on 26
        int result = 0;
        int weight = 26;
        for (Integer count : list) {
            result = result + count * weight--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getBeauty("p"));

    }
}
// 78 + 50 + 24 + 23