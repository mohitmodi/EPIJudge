package bigbubuclass;

import java.util.*;

public class CompressNumber {

    public static void main(String[] args) {
        int arr[] = new int[]//{8, 4, 2, 2};
       {4, 4, 5, 4,4,4};
        //{1, 9, 9, 3, 3, 3, 4};
        int k = 2;
        //5;
        // 3;
        CompressNumber compressNumber = new CompressNumber();
        System.out.println(Arrays.toString(compressNumber.compress(arr, k)));
    }

    class Data {
        int value;
        int freq;

        Data(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    private int[] compress(int[] arr, int k) {
        if (arr.length < k) {
            return arr;
        }
        Stack<Data> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Data(arr[i], 1));
            } else {
                if (stack.peek().value == (arr[i])) {
                    if (stack.peek().freq == k - 1) {
                        stack.pop();
                        int compressedValue = arr[i] * k;
                        while (!stack.isEmpty() && stack.peek().value == (compressedValue)) {
                            if (stack.peek().freq == k - 1) {
                                stack.pop();
                                compressedValue = compressedValue * k;
                            }
                        }
                        stack.push(new Data(compressedValue, 1));
                    } else {
                        Data pop = stack.pop();
                        stack.push(new Data(pop.value, pop.freq + 1));
                    }
                } else {

                    stack.push(new Data(arr[i], 1));
                }

            }
        }
        int[] res = new int[stack.size()];
        int i = 1;
        while (!stack.isEmpty()) {
            res[res.length - i] = stack.pop().value;
            i++;
        }
        return res;

    }
}
