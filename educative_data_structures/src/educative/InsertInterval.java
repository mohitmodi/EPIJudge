package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insertInterval(int[][] existingInterval, int[] newInterval) {
        //[1,2],[3,5],[6,8]
        //[5,7]
        List<int[]> result = new ArrayList<>();

        int firstStartTime = existingInterval[0][0];
        int firstendTime = existingInterval[0][1];
        int newIntervalEndTime = newInterval[1];
        int newIntervalStartTime = newInterval[0];
        boolean isnewIntervalInseerted = false;

        int i = 0;
        int n = existingInterval.length;
        while (i < n && firstendTime < newIntervalStartTime) {
            result.add(existingInterval[i]);
            firstendTime = existingInterval[i][1];
            firstStartTime = existingInterval[i][0];
            i++;
        }
        if (result.isEmpty()) {
            int[] newEntry = new int[]{Math.min(firstStartTime, newIntervalStartTime), Math.max(firstendTime, newIntervalEndTime)};
            result.add(newEntry);
            i++;
        } else if (firstendTime < newIntervalStartTime) {
            result.add(newInterval);
        } else {
            result.get(result.size() - 1)[1] = Math.max(firstendTime, newIntervalEndTime);
        }


        int prevEndTime = result.get(result.size() - 1)[1];
        int prevStartTime = result.get(result.size() - 1)[0];
        while (i < n) {
            int startTimeNext = existingInterval[i][0];
            int endTimeNext = existingInterval[i][1];
            if (prevEndTime < newIntervalStartTime && newIntervalStartTime < startTimeNext) {
                result.add(newInterval);

            } else if (prevEndTime == newIntervalStartTime) {
                result.get(result.size() - 1)[1] = Math.max(prevEndTime, newIntervalEndTime);

            } else if (prevEndTime >= startTimeNext) {
                result.get(result.size() - 1)[1] = Math.max(prevEndTime, endTimeNext);
                i++;
            } else {
                result.add(existingInterval[i]);
                i++;
            }
            prevEndTime = result.get(result.size() - 1)[1];

        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] newIntervals = {
                {16, 17},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 4}, {5, 8}, {9, 15}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
