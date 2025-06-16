package exponent;

public class MoveAllZeroesToEnd {
    public static int[] moveZerosToEnd(int[] arr) {
        int lastIndexOfNonZero = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                if (j != lastIndexOfNonZero) {
                    int temp = arr[j];
                    arr[j] = arr[lastIndexOfNonZero];
                    arr[lastIndexOfNonZero] = temp;
                }
                lastIndexOfNonZero++;
            }
        }
        return arr;
    }

    // debug your code below
    public static void main(String[] args) {
        int[] example = {0, 1, 0, 3, 12};
        moveZerosToEnd(example);
        for (int num : example) {
            System.out.print(num + " ");
        }
    }
}
