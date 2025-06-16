package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int[] startInterval = intervals[0];
        int endTimeOfStartInterval = startInterval[1];
        result.add(startInterval);
        for (int[] nextInterval : intervals) {
            int newStartTime = nextInterval[0];
            int newEndTimeInterval = nextInterval[1];
            int newEndTime = Math.max(endTimeOfStartInterval, newEndTimeInterval);
            if (endTimeOfStartInterval >= newStartTime) {
                result.get(result.size() - 1)[1] = newEndTime;
            } else {
                result.add(nextInterval);
            }
            endTimeOfStartInterval = newEndTime;
        }
        return result.toArray(new int[][]{});

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int[] firstInterval = intervals[0];
        result.add(firstInterval);
        int endTime = firstInterval[1];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            int newStartTime = nextInterval[0];
            int newEndTime = nextInterval[1];
            if (endTime >= newStartTime) {
                result.get(result.size() - 1)[1] = Math.max(newEndTime, endTime);
            } else {
                result.add(nextInterval);
            }
            endTime = Math.max(newEndTime, endTime);
        }
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][][] allIntervals = {
                {{2, 5}, {1, 5}, {2, 8},{7,9},{11,12}},
                {{1, 9}, {3, 8}, {4, 4}},
                {{1, 2}, {3, 4}, {8, 8}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        int index = 1;
        for (int[][] intervals : allIntervals) {
            System.out.println(index + ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            //int[][] result = merge(intervals);
            System.out.println(attendAllMeetings(intervals));
            //System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    public static boolean attendAllMeetings(int[][] intervals) {
        Arrays.sort(intervals, (Comparator<int[]>) (o1, o2) -> o1[0] - o2[0]);
        int prevEndTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            System.out.println(prevEndTime);
            int startTime = intervals[i][0];
            if (startTime < prevEndTime)
                return true;
            prevEndTime = intervals[i][1];

        }
        return false;
    }

}
