package bigbubuclass;

public class BitonicArray {
    public static void main(String[] args) {
        int arr[] = new int[]{8, 5, 3, 2};
        System.out.println(findMax(arr));
    }

    private static int findMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end && mid >= 0 && mid <= arr.length - 1) {
            if ((mid == 0 && arr[mid] > arr[mid + 1]) || (mid == arr.length - 1) && arr[mid] > arr[mid - 1]) {
                return arr[mid];
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            if (arr[mid] > arr[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return -1;
    }

}
