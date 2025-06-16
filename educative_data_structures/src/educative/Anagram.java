package educative;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) - 1);
            if (map.get(str2.charAt(i)) <= 0) {
                map.remove(str2.charAt(i));
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
