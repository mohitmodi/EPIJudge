package bigbubuclass;

import java.util.*;

public class WindowMedian {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = new int[]{-1, 5, 13, 8, 2, 3, 3, 1};

        System.out.println(median(arr, k));

    }

    private static List<Integer> median(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int j = 0;
        int removeIndex = 0;
        List<Integer> window = new ArrayList<>();
        while (j < k) {
            window.add(arr[j]);
            j++;
        }
        Collections.sort(window);
        if (k % 2 == 0) {
            result.add((window.get(k / 2) + window.get((k + 1) / 2)) / 2);
        } else {
            result.add(window.get(k / 2));
        }
        for (int i = j; i < arr.length; i++) {

            window.remove((Integer) arr[removeIndex]);
            removeIndex++;
            int newEntry = arr[i];
            int positionForNewEntry = findPositionForNewEntry(newEntry, window);
            window.add(positionForNewEntry, newEntry);
            if (k % 2 == 0) {
                result.add((window.get(k / 2) + window.get((k + 1) / 2)) / 2);
            } else {
                result.add(window.get(k / 2));
            }
        }
        return result;
    }

    private static int findPositionForNewEntry(int newEntry, List<Integer> window) {
        int start = 0;
        int end = window.size();
        int mid = 0;
        while (start < end) {
            mid = (end + start) / 2;
            if (window.get(mid) < newEntry && mid < end && window.get(mid + 1) > newEntry) {
                return mid + 1;
            } else if (window.get(mid) > newEntry) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
