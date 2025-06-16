package educative;

import java.util.*;


//1 3 5 14 18 14 5
//k=2
public class KFrequentElements {
    public static List<Integer> topKFrequent(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        map.entrySet().forEach(entry -> {
            if (minHeap.size() == k) {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }else{
                minHeap.offer(entry);
            }

        });
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {1, 3, 4, 2};
        for (int i = 0; i < inputK.length; i++) {
            List<Integer> result = topKFrequent(inputs[i], inputK[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput: (" + Arrays.toString(inputs[i]) + ", " + inputK[i] + ")");
            System.out.println("\n\tTop " + inputK[i] + " frequent elements: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
