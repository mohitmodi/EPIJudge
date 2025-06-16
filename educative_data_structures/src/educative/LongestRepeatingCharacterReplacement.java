package educative;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string s and an integer k,
// find the length of the longest substring in s,
// where all characters are identical,
// after replacing, at most,
// k characters with any other lowercase English character.
//aabccbb k=2
//5
//bccbb replce 2 c with 2 b
public class LongestRepeatingCharacterReplacement {

    public int longestRepeatingCharacterReplacement(String s, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int mostFrequent = 0;
        int maxLength = 1;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char currCharacter = s.charAt(end);
            frequencyMap.put(currCharacter, frequencyMap.getOrDefault(currCharacter, 0) + 1);
            mostFrequent = Math.max(mostFrequent, frequencyMap.get(currCharacter));
            if (end - start + 1 + mostFrequent > k) {
                frequencyMap.put(s.charAt(start), frequencyMap.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }

    public static int longestRepeatingCharacterReplacement1(String s, int k) {
        int maxLength = 0;
        int startIndex = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            freqMap.put(s.charAt(end), freqMap.getOrDefault(s.charAt(end), 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(s.charAt(end)));
            if (end - startIndex + 1 - maxFreq > k) {
                freqMap.put(s.charAt(startIndex), freqMap.get(s.charAt(startIndex)) - 1);
                startIndex++;
            }
            maxLength = Math.max(maxLength, end - startIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement1(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
