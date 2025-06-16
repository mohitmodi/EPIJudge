package bigbubuclass;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerNumber {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 0, 3, 4, 5};
        System.out.println(Arrays.toString(smallerNumber(arr)));
    }

    private static int[] smallerNumber(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        res[0] = -1;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() < arr[i]) {
                res[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    res[i] = -1;
                else
                    res[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
