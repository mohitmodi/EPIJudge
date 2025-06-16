package bigbubuclass;

import java.util.HashMap;
import java.util.List;

public class ChainCircle {
    public static void main(String[] args) {
        List<String> input = List.of("chair", "height", "racket", "touch", "tunic");
        System.out.println(circle(input));
    }

    private static boolean circle(List<String> input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (String word : input) {
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        return map.values().stream().allMatch(value -> value.equals(0));
    }
}
