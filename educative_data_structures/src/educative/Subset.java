package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static List<List<Integer>> findSubset(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        findAllSubset(0, num, res, new ArrayList<>());
        return res;
    }

    private static void findAllSubset(int index, int[] num, List<List<Integer>> res, List<Integer> currList) {
        //base case
        if (index == num.length) {
            res.add(new ArrayList<>(currList));
            return;
        }
        currList.add(num[index]);
        findAllSubset(index + 1, num, res, currList);
        currList.remove(currList.size() - 1);
        findAllSubset(index + 1, num, res, currList);
    }
    public static void main(String[] args) {
        int[][] inputSets = {
                {},
                {2, 5, 7},
                {1, 2},
                {1, 2, 3, 4},
                {7, 3, 1, 5}
        };

        for (int i = 0; i < inputSets.length; i++) {
            int[] set = inputSets[i];
            System.out.println((i + 1) + ". Set: " + Arrays.toString(set));
            List<List<Integer>> subsets = findSubset(set);
            System.out.println("   Subsets: " + subsets);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
