package educative;

import java.util.HashMap;
import java.util.Map;

//abbba
public class Longestpalindrome {
    public static int longestPalindrome(String s) {
        int maxLength = 0;
        boolean oddChar = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                maxLength += entry.getValue();
            } else {
                if (oddChar) {
                    maxLength += entry.getValue() - 1;
                } else {
                    maxLength += entry.getValue();
                    oddChar = true;
                }
            }
        }
        return maxLength;

    }
}
