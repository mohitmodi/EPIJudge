package educative;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0 || n == 0) return tasks.length;

        Map<Character, Integer> taskCount = new HashMap<>(); /* key: task, value: amount of this task remained */
        for (Character t : tasks) {
            taskCount.put(t, taskCount.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> taskPool = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Character, Integer> entry : taskCount.entrySet()) {
            taskPool.add(entry);
        }

        int intervals = 0;
        while (!taskPool.isEmpty()) {
            /* start a new work period */
            List<Map.Entry<Character, Integer>> tasksInPeriod = new ArrayList<>();
            int period = n + 1;
            while (period > 0 && !taskPool.isEmpty()) {
                Map.Entry<Character, Integer> currTask = taskPool.poll();
                currTask.setValue(currTask.getValue() - 1);
                tasksInPeriod.add(currTask);

                intervals++;
                period--;
            }

            /* add remaining tasks to taskPool */
            for (Map.Entry<Character, Integer> remainedTask : tasksInPeriod) {
                if (remainedTask.getValue() > 0) taskPool.add(remainedTask);
            }

            /* check if job done */
            if (taskPool.isEmpty()) break;
            else {
                /* check if idle slots needed */
                if (period > 0) intervals += period;
            }
        }
        return intervals;
    }
}
