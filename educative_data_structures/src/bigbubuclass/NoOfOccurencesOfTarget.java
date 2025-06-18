package bigbubuclass;

public class NoOfOccurencesOfTarget {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1,1, 2, 2,2,2,2,2};
        int target = 2;
        System.out.println(noOfOccurence(arr, target));
    }

    private static int noOfOccurence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        int noOfOccurence = 0;
        while (start < end) {
            if (arr[mid] == target) {
                noOfOccurence++;
                int i = mid-1;
                while (i >= 0 && arr[i] == target) {
                    noOfOccurence++;
                    i--;
                }
                i = mid + 1;
                while (i < arr.length && arr[i] == target) {
                    noOfOccurence++;
                    i++;
                }
                return noOfOccurence;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return noOfOccurence;
    }
}
