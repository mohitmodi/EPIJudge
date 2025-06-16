package educative;

import java.util.*;

public class ThreeSum {
    public static boolean threeSum(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            if (twoSum(num, target - num[i], i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean twoSum(int[] num, int target, int currIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (currIndex != i)
                map.put(target - num[i], i);
        }
        for (int i = 0; i < num.length; i++) {

            if (map.containsKey(num[i]) && currIndex != i && map.get(num[i]) != i) {
                return true;
            }
        }
        return false;
    }

    public static boolean threeSum2pointer(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;

            while (j < k) {
                int currSum = num[i] + num[j] + num[k];
                if (currSum == target) {
                    return true;
                } else if (currSum > target) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] numsList = {
                {-1, 2, 1, -4, 5, -3},
                {1, -1, 0},
        };

        int[] testList = {7, -1};


        for (int i = 0; i < testList.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            /*if (threeSum2pointer(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }*/
            if (threeSum(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }


            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
