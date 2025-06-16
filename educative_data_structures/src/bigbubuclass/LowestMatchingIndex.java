package bigbubuclass;

public class LowestMatchingIndex {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 40, 200, 350};
        System.out.println(lowestMatchingIndex(arr));
    }

    private static Integer lowestMatchingIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        Integer ans = null;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                if (arr[mid] == mid)
                    ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
