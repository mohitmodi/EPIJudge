package bigbubuclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str1 = method2(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring2: " + str1);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int method2(String input) {

        int maxlenSoFar = 0;
        int left = 0;

        Set<Character> set = new HashSet<>();
        for (int right = 0; right < input.length(); right++) {
            while (set.contains(input.charAt(right))) {
                set.remove(input.charAt(left));
                left++;
            }
            set.add(input.charAt(right));
            maxlenSoFar = Math.max(maxlenSoFar, right - left + 1);
        }


        return maxlenSoFar;
    }
}
