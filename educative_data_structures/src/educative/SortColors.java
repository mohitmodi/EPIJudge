package educative;

import java.util.Arrays;

public class SortColors {
    //1 0 2 1 2 2
    //0 1 1 2 2 2

    public static int[] sortColors(int[] colors) {
        int start = 0;
        int end = colors.length - 1;
        int curr = 0;
        while (curr <= end) {
            if (colors[curr] == 2) {
                swap(end, curr, colors);
                end--;
            }
            else if (colors[curr] == 1) {
                curr++;
            }
           else {
                swap(start, curr, colors);
                start++;
                curr++;
            }
        }
        return colors;
    }

    private static void swap(int end, int curr, int[] colors) {
        int temp = colors[end];
        colors[end] = colors[curr];
        colors[curr] = temp;
    }
    public static void main(String[] args) {
        int[][] inputs = {

                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

            //System.out.println(Print.repeat("-", 100));
        }
    }
}
