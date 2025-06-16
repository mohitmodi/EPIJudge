package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//[[4, 7], [9, 16], [17, 28], [39, 50], [55, 66], [70, 89]]
//[[3, 6], [7, 8], [9, 10], [14, 19], [23, 33], [35, 40], [45, 59], [60, 64], [68, 76]]
//[[4, 6], [7, 7], [9, 10], [14, 16], [17, 19], [23, 28], [39, 40], [45, 50], [55, 59], [60, 64], [70, 76]]
public class IntervalListIntersection {
    public static int[][] intervalsIntersection(int[][] a, int[][] b) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[][]{});

    }


    public static void main(String args[]) {
        int[][][] inputIntervalLista = {

                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},

        };

        int[][][] inputIntervalListb = {

                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},

        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
