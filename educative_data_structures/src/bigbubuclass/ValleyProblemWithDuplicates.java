package bigbubuclass;

public class ValleyProblemWithDuplicates {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 7, 7, 7, 7, 7, 6};
        System.out.println(findSmallest(arr));
    }

    private static int findSmallest(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid > 0 && arr[mid] < arr[mid - 1] && mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                return arr[mid];
            }
            if (mid > 0 && arr[mid] > arr[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[mid];
    }


}
