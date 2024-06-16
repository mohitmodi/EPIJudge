import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
//
//In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:
//
//Input :
//In Bakery department: From 8 to 10
//In Checkout department: From 10 to 12
//In Diary department: From 14 to 19
//
//Given the above split of shifts, provide an API/method to return the
// different shifts of a colleague for the day after merging contiguous shifts.
// This will be exposed to the colleague in different UI and help them plan their day accordingly.
//
//Output:
//His shift timings in this case are 8 to 12 and 14 to 19.
public class Test {
    static List<int[]> mergeInterval(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result;
        }
        Arrays.sort(intervals, new CustomComparator());

        int[] firstInterval = intervals[0];
        int startTime = firstInterval[0];
        int endTime = firstInterval[1];
        result.add(firstInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            int currStartTime = currInterval[0];
            int currEndTime = currInterval[1];
            if (currStartTime <= endTime) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], currEndTime);
            } else {
                result.add(currInterval);
            }
            endTime=currEndTime;

        }

        return result;
    }
}

class CustomComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{{8, 10}, {10, 12}, {14, 19}};
        int[][] input1 = new int[][]{{8, 11}, {10, 12}, {14, 19}, {2,4}};

        List<int[]> output = Test.mergeInterval(input1);
        for(int [] res:output){
            System.out.println(res[0] + " to " +res[1]);
        }
    }

}

