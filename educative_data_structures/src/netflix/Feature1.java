package netflix;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Feature1 {

    public static List<List<String>> groupTitle(List<String> input) {
        Map<String, List<String>> map = new HashMap();
        List<List<String>> result = new ArrayList<>();
        for (String string : input) {
            String string1 = Arrays.stream(string.split("")).sorted().collect(Collectors.joining());
            List<String> orDefault = map.getOrDefault(string1, new ArrayList<>());
            orDefault.add(string);
            map.put(string1, orDefault);

          //  map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(string);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"};

        List<List<String>> gt = groupTitle(List.of(titles));
        String query = "spede";

        // Searching for all titles
        for (List<String> g : gt) {
            if (g.contains(query))
                System.out.println(g);
        }
    }
}

