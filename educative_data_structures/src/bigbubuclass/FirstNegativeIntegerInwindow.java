package bigbubuclass;

import java.util.*;

public class FirstNegativeIntegerInwindow {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 1, 3, 5};
        int k = 3;
        System.out.println(firstNegativesMM(arr, k));
    }

    private static List<Integer> firstNegatives(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        for (int i = 0; i <= arr.length - k + 1; i++) {
            int j = 0;
            while (j < k) {
                if (arr[j + i] < 0) {
                    index.add(j + i);
                }
                j++;
            }
            boolean found = false;
            for (int p = 0; p < index.size(); p++) {
                if (index.get(p) >= i) {
                    res.add(arr[index.get(p)]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.add(0);
            }
        }
        return res;
    }

    private static List<Integer> firstNegativesMM(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        while (i < k) {
            if (arr[i] < 0)
                dq.addLast(i);
            i++;
        }
        if (!dq.isEmpty())
            res.add(arr[dq.peekFirst()]);
        else {
            res.add(0);
        }
        int start = 1;
        while (i < arr.length) {
            if (arr[i] < 0)
                dq.addLast(i);
            if (!dq.isEmpty() && dq.peekFirst() < start)
                dq.pollFirst();
            if (dq.isEmpty())
                res.add(0);
            else
                res.add(arr[dq.peekFirst()]);
            i++;
            start++;
        }
        return res;
    }
}
