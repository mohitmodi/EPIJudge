package bigbubuclass;

import java.util.*;

public class BestSellingTitle {
    public static void main(String[] args) {
        List<String> list = List.of("b3", "b1", "b3", "b3", "b2", "b3", "b4", "b3");
        int k = 3;
        System.out.println(kDayNewBestSeller(list, k));
    }

    private static boolean kDayNewBestSeller(List<String> list, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        while (end <= list.size() - 1) {
            if (!map.containsKey(list.get(end))) {
                map.put(list.get(end), end);
                if (end - start == k) {
                    return true;
                }
                end++;
            } else {
                int index = map.get(list.get(end));
                start = index + 1;
                Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> next = iterator.next();
                    if (next.getValue() < start) {
                        iterator.remove();
                    }
                }
                map.put(list.get(end), end);
                end++;
            }
        }
        return false;
    }
}
