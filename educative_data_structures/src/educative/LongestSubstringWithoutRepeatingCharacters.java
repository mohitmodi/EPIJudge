package educative;


//p w w k e w

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int findLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int lenght = 1;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)) && start <= map.get(s.charAt(end))) {
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);
            lenght = Math.max(lenght, end - start+1);
        }
        return lenght;
    }

    public static void main(String[] arg) {
        String[] inputs = {
                "Q",
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = LongestSubstringWithoutRepeatingCharacters.findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int findLongestSubstring2(String s) {

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
}
