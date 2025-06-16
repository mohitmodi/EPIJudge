package educative;

import java.util.*;

public class ScheduleTaskOnMinimumMAchine {
    public static int scheduleTaskOnMinmumMachines(List<List<Integer>> tasks) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.getFirst() - o2.getFirst();
            }
        });
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        for (List<Integer> task : tasks) {
            pq.offer(task);
        }
        int machineCount=0;
        while (!pq.isEmpty()) {
            List<Integer> currTask = pq.poll();
        }
        return taskQueue.size();
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> inputs = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(1, 1),
                        Arrays.asList(5, 5),
                        Arrays.asList(8, 8),
                        Arrays.asList(4, 4),
                        Arrays.asList(6, 6),
                        Arrays.asList(10, 10),
                        Arrays.asList(7, 7)
                ),
                Arrays.asList(
                        Arrays.asList(1, 7),
                        Arrays.asList(1, 7),
                        Arrays.asList(1, 7),
                        Arrays.asList(1, 7),
                        Arrays.asList(1, 7),
                        Arrays.asList(1, 7)
                ),
                Arrays.asList(
                        Arrays.asList(1, 7),
                        Arrays.asList(8, 13),
                        Arrays.asList(5, 6),
                        Arrays.asList(10, 14),
                        Arrays.asList(6, 7)
                ),
                Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(3, 5),
                        Arrays.asList(5, 9),
                        Arrays.asList(9, 12),
                        Arrays.asList(12, 13),
                        Arrays.asList(13, 16),
                        Arrays.asList(16, 17)
                ),
                Arrays.asList(
                        Arrays.asList(12, 13),
                        Arrays.asList(13, 15),
                        Arrays.asList(17, 20),
                        Arrays.asList(13, 14),
                        Arrays.asList(19, 21),
                        Arrays.asList(18, 20)
                )
        );

        List<List<List<Integer>>> inputTaskList = new ArrayList<>();
        for (int j = 0; j < inputs.size(); j++) {
            inputTaskList.add(new ArrayList<>());
            for (int k = 0; k < inputs.get(j).size(); k++) {
                inputTaskList.get(j).add(new ArrayList<>(inputs.get(j).get(k)));
            }
        }

        for (int i = 0; i < inputTaskList.size(); i++) {
            System.out.println(i + 1 + ".\tTask = " + inputTaskList.get(i).toString());
            System.out.println("\tOptimal number of machines = " + scheduleTaskOnMinmumMachines(inputTaskList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
