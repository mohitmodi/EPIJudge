package educative;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {


    public static boolean isIsomorphic(String string1, String string2) {
        String hash1 = hash(string1);
        String hash2 = hash(string2);
        return hash1.equals(hash2);
    }

    public static String hash(String s) {
        Map<Character, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
            } else {
                map.put(s.charAt(i), i);
            }
            sb.append(map.get(s.charAt(i)));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "abb";
        System.out.println(isomorphicString(s1, s2));

    }


    public static boolean isomorphicString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String hash = calculateHash(s1);
        return hash.equals(calculateHash(s2));
    }

    private static String calculateHash(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                sb.append(map.get(s.charAt(i)) + i);
            } else {
                map.put(s.charAt(i), i);
                sb.append(map.get(s.charAt(i)));
            }
        }
        return sb.toString();
    }

}
