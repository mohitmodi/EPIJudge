package educative;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindowDnaSequence {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCC";
        int k = 8;
        System.out.println(findRepeatedSequences(s, k));
    }

    public static Set<String> findRepeatedSequences(String s, int k) {
        Set<String> result = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, j = i + k; i < s.length(); i++, j++) {
            if(j<=s.length()) {
                String sub = s.substring(i, j);
                if (map.containsKey(sub)) {
                    result.add(sub);
                } else {
                    map.put(sub, 1);
                }
            }

        }
        return result;
    }
}
