package com.playground;

import java.util.*;

public class JumbleWordsRested {

    static String[] numbers = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static Map<String, String> mapping = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getJumbledWords("veiifogvweesotwnetnvfeheiotveiifogvweesotwnetnvfeheiotveiifogvweesotwnetnvfeheiotveiifogvweesotwnetnvfeheiot"));
    }

    private static String getJumbledWords(String input) {
        StringBuilder result = new StringBuilder();
        mapping.put("zero","0");
        mapping.put("one","1");
        mapping.put("two","2");
        mapping.put("three","3");
        mapping.put("four","4");
        mapping.put("five","5");
        mapping.put("six","6");
        mapping.put("seven","7");
        mapping.put("eight","8");
        mapping.put("nine","9");

        List<Character> inputList = new ArrayList<>();
        for (Character character : input.toCharArray()) {
            inputList.add(character);
        }

        for (String number : numbers) {
            while (isContained(inputList,number)) {
                result.append(mapping.get(number));
            }
        }
        return result.toString();

    }

    private static boolean isContained(List<Character> inputList, String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!inputList.contains(number.charAt(i))) {
                return false;
            }
        }

        for (Character character : number.toCharArray()) {
            inputList.remove(character);
        }
        return true;
    }
}
