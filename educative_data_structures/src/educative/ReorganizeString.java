package educative;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    String s = "aabc";

    public static String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> maxPq = new PriorityQueue<Map.Entry<Character, Integer>>(
                (item1, item2) -> item2.getValue() - item1.getValue());
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxPq.offer(entry);
        }
        char prevChar;
        while (!maxPq.isEmpty()) {
            char currMaxChar = maxPq.poll().getKey();
            if(sb.isEmpty()){
                sb.append(currMaxChar);
                prevChar=currMaxChar;
            }
            /*else if(prevChar)*/


        }
        if (!maxPq.isEmpty()) {
            return "";
        } else {
            return sb.toString();
        }
    }
}
