package bigbubuclass;

import java.util.Stack;

public class SettingSun {
    //Bonus: 285: You are given an array representing the heights of neighboring buildings on a city street,
    // from east to west. The city assessor would like you to write an algorithm that returns
    // how many of these buildings have a view of the setting sun, in order to properly value the street.
    //
    //For example, given the array [3, 7, 8, 3, 6, 1],
    // you should return 3, since the top floors of the buildings with heights 8, 6, and 1
    // all have an unobstructed view to the west.

    public static void main(String[] args) {
        int arr[] = new int[]{3, 7, 8, 3, 6, 1};
        System.out.println(settingSun(arr));

    }

    private static int settingSun(int[] arr) {
        int count = 0;
        java.util.Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            if (stack.isEmpty()) {
                stack.push(curr);
                count++;
            } else if (stack.peek() < curr) {
                count++;
                stack.pop();
                stack.push(curr);
            }
        }
        return count;
    }
}
