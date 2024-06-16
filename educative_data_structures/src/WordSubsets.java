import java.util.*;

public class WordSubsets {
    public static List<String> wordSubsets(List<String> A, List<String> B) {

        List<String> result = new ArrayList<>();

        A.stream().forEach(b -> {
            Map<Character, Integer> map = new HashMap<>();
            B.stream().forEach(ba -> {
                for (Character c : ba.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            });
            for (Character c : b.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }
                if (map.containsKey(c) && map.get(c) <= 0) {
                    map.remove(c);
                }
            }
            if (map.isEmpty()) {
                result.add(b);
                System.out.println(b);
            }
        });

        return result;
    }

    public static void main(String[] args) {
        List<String> A = Arrays.asList("orange", "room", "more");
        List<String> B = Arrays.asList("rm", "oo");
        wordSubsets(A, B);
    }
}
