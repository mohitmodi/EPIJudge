package educative;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
                map.put(nums2[i], -1);
            } else if (nums2[i] > stack.peek()) {
                while (nums2[i] > stack.peek()) {
                    stack.pop();
                    if(stack.isEmpty()){
                        map.put(nums2[i], -1);
                        break;
                    }
                }
                if(!stack.isEmpty()){
                    map.put(nums2[i], stack.peek());

                }
                stack.push(nums2[i]);

            } else {
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    public static int[] nextGreaterElement2(int[] nums1) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums1.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums1[i]);
                result[i]=-1;
            } else if (nums1[i] > stack.peek()) {
                while (nums1[i] > stack.peek()) {
                    stack.pop();
                    if(stack.isEmpty()){
                        result[i]=-1;
                        break;
                    }
                }
                if(!stack.isEmpty()){
                    result[i]=stack.peek();

                }
                stack.push(nums1[i]);

            } else {
                result[i]=stack.peek();
                stack.push(nums1[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {

                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {

                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };

        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement2(A[i])));
        }
    }
}

