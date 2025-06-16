package educative;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PalindromePermutation {
    public static void main(String[] args) {
        String s = "aabx";
        String s1 = "aa";
        System.out.println(isPermutationPalindrome(s1));
        System.out.println(palindromePermutation(s1));
    }

    public static boolean isPermutationPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int oddCounter = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                oddCounter++;
            }
            if (oddCounter>1){
                return false;
            }
        }
        return true;
    }


    public static boolean palindromePermutation(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int oddCounter = 0;
        boolean b = true;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                oddCounter++;
            }
            if (oddCounter > 1) {
                b = false;
            }
        }
        return b;

    }
}
