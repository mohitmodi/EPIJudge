package exponent;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("duel", "dule", "speed", "spede", "cars");
        System.out.println(anagrams(input));

    }

    private static List<List<String>> anagrams(List<String> input) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> freqMap = new HashMap<>();

        for (String str : input) {
            String hash = calculateHash(str);
            freqMap.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }
        for (Map.Entry<String, List<String>> entry : freqMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private static String calculateHash(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = new char[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            charArray[index]++;
        }
        for (int i = 0; i < 26; i++) {
            sb.append(" ");
            sb.append(charArray[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
