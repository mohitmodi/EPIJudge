package bigbubuclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "DFFDFDFVD";
        String s2 = "VDD";
        System.out.println(minWindSubstring(s1, s2));
    }

    private static int minWindSubstring(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();
        int currLength = 0;
        int minLength = s1.length() + 1;
        for (int i = 0; i < s2.length(); i++) {
            freqMap.put(s2.charAt(i), freqMap.getOrDefault(s2.charAt(i), 0) + 1);
            currMap.put(s2.charAt(i), 0);
        }
        int reqdLength = freqMap.size();
        int i = 0;
        int j = 0;
        while (j < s1.length()) {
            char c = s1.charAt(j);
            if (freqMap.containsKey(c)) {
                currMap.put(c, currMap.get(c) + 1);
                currLength = currMap.get(c).equals(freqMap.get(c)) ? currLength + 1 : currLength;
            }
            while (currLength == reqdLength) {
                minLength = Math.min(minLength, j - i + 1);
                char curr = s1.charAt(i);
                if (currMap.containsKey(curr)) {
                    currMap.put(curr, currMap.get(curr) - 1);
                    currLength = currMap.get(curr).equals(freqMap.get(curr)) ? currLength : currLength - 1;
                }
                i++;
            }
            j++;
        }
        return minLength == s1.length() + 1 ? 0 : minLength;
    }
}
