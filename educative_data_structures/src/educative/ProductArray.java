package educative;

import java.util.Arrays;
import java.util.Collections;

public class ProductArray {
    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, left = 1;
        int product[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            product[i] = left;
            left *= arr[i];
            System.out.printf("%n\t List of products pass 1: %s%n", Arrays.toString(product));

        }

        // Second pass: Update the product list by calculating products from right to left
        int right = 1;
        for (i = n - 1; i >= 0; i--) {
            product[i] *= right;
            right *= arr[i];
            System.out.printf("%n\t List of products pass 2: %s%n", Arrays.toString(product));

        }

        return product;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4},
                {5, -3, 1, 2},
                {2, 2, 2, 0},
                {0, 0, 0, 0},
                {-1, -2, -4}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("%d.\t Array: %s%n", i + 1, Arrays.toString(inputs[i]));
            System.out.printf("%n\t List of products: %s%n", Arrays.toString(findProduct(inputs[i])));
            System.out.println('-' + String.join("", Collections.nCopies(70, "-")) + '\n');
        }
    }
}
