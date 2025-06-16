package educative;

import java.util.*;
import java.util.stream.Collectors;

public class GroupSimilarTitles {
    public static List<List<String>> groupTitles(List<String> strs, List<String> query) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = calculateHash(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }

        for (String quer : query) {
            List<String> result = new ArrayList<>();
            String hash = calculateHash(quer);
            if (map.containsKey(hash)) {
                result.addAll(map.get(hash));
            }
            results.add(result);
        }
        return results;
    }

    private static String calculateHash(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = new char[26];
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            charArray[index]++;
        }
        for (int i = 0; i < 26; i++) {
            sb.append(" ");
            sb.append(charArray[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"};
        String query[] = {"spede"};

        List<List<String>> gt = groupTitles(Arrays.stream(titles).toList(), Arrays.stream(query).toList());

        // Searching for all titles
        for (List<String> g : gt) {
            System.out.println(g);
        }
    }
    public static List<List<String>> groupTitles(List<String> strs) {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = calculateHash(str);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        map.forEach((key, value) -> results.add(value));


        return results;
    }
}
