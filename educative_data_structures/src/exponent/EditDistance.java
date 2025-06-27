package exponent;

import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "hit";
        String s2 = "cot";
        List<String> wordList = Arrays.asList("hit", "hot", "dot", "dog", "cog");
        System.out.println(editDistance(s1, s2, wordList));
    }


    private static int editDistance(String s1, String s2, List<String> wordList) {
        if (s1.equals(s2)) {
            return 0;
        }
        //construct 1editditance graph
        Map<String, List<String>> oneEditDistanceGraph = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            String baseWord = wordList.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                if (i != j) {
                    String newWord = wordList.get(j);
                    if (isOneEditDistanceWord(baseWord, newWord)) {
                        oneEditDistanceGraph.computeIfAbsent(baseWord, k -> new ArrayList<>()).add(newWord);
                    }
                }
            }
        }


        // traverse the graph

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair<>(s1, 0));
        visited.add(s1);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String currWord = pair.getKey();
            int editDistance = pair.getValue();
            for (String word : oneEditDistanceGraph.getOrDefault(currWord, new ArrayList<>())) {
                if (!visited.contains(word)) {
                    if (word.equals(s2)) {
                        return editDistance + 1;
                    }
                    queue.add(new Pair<>(word, editDistance + 1));
                    visited.add(word);
                }
            }
        }
        return -1;
    }

    private static boolean isOneEditDistanceWord(String baseWord, String newWord) {
        if (baseWord.length() != newWord.length()) {
            return false;
        }
        int diffcount = 0;
        for (int i = 0; i < baseWord.length(); i++) {
            if (baseWord.charAt(i) != newWord.charAt(i)) {
                diffcount++;
            }
            if (diffcount > 1) {
                return false;
            }

        }
        return true;
    }

    static class Pair<K, V> {
        K key;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        V value;


        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}


