package bigbubuclass;

import java.util.ArrayList;
import java.util.List;

public class MatchingPatternInString {
    //Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string.
    // For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].


    public static void main(String[] args) {
        String s = "bbbbb";
        String pattern = "bb";
        System.out.println(findOccurrence(s, pattern));
    }

    private static List<Integer> findOccurrence(String s, String pattern) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++) {
            int j = 0;
            int startIndex = i;
            while (j < pattern.length()) {
                if (startIndex < s.length() && s.charAt(startIndex) == pattern.charAt(j)) {
                    j++;
                    startIndex++;

                } else {
                    break;
                }
            }
            if (j == pattern.length()) {
                result.add(i);
            }
        }
        return result;
    }
}
