import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestUniqueCharacterSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (windowEnd < s.length()) {
            if (map.containsKey(s.charAt(windowEnd)) && map.get(s.charAt(windowEnd)) >= windowStart) {
                windowStart = map.get(s.charAt(windowEnd)) + 1;
            }
            map.put(s.charAt(windowEnd), windowEnd);
            maxLength = Math.max(maxLength, windowEnd + 1 - windowStart);
            windowEnd++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueCharacterSubstring("PWWKEW"));
    }
}
