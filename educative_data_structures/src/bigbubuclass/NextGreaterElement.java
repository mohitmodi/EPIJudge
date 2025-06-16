package bigbubuclass;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = new int[]{50, 40, 30, 10};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }

    private static int[] nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[arr.length];
        res[arr.length - 1] = -1;
        stack.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < stack.peek()) {
                res[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
