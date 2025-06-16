package bigbubuclass;

import java.util.*;

public class SortedLetterFrequency {
    public static void main(String[] args) {
        String words = "helloo worlddd";
        System.out.println(sort(words));
    }

    private static List<Character> sort(String word) {
        HashMap<Character, Integer> freqMap = new HashMap();


        char[] input = word.toCharArray();
        for (int i = 0; i < input.length; i++) {
            freqMap.put(word.charAt(i), freqMap.getOrDefault(word.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return Character.compare(a.getKey(), b.getKey());
        });
        maxHeap.addAll(freqMap.entrySet());


        List<Character> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}
