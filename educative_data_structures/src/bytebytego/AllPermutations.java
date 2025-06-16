package bytebytego;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {


    public static List<List<Integer>> allPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, arr);
        return result;
    }

    private static void backtrack(ArrayList<Integer> currChoice, List<List<Integer>> result, int[] arr) {
        if (currChoice.size() == arr.length) {
            result.add(new ArrayList<>(currChoice));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (currChoice.contains(arr[i])) {
                continue;

            }
            currChoice.add(arr[i]);
            backtrack(currChoice, result, arr);
            currChoice.remove(currChoice.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6};
        System.out.println(allPermutations(arr));
    }
}
