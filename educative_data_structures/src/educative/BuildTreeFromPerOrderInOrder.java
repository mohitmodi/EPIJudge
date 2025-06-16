package educative;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPerOrderInOrder {
    public static TreeNode<Integer> buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        int[] pIndex = {0};
        return buildTree(pre, in, map, 0, pre.length - 1, pIndex);

    }

    private static TreeNode<Integer> buildTree(int[] pre, int[] in, Map<Integer, Integer> map, int left, int right, int[] preIndex) {
        if (left > right) {
            return null;
        }
        int curr = pre[preIndex[0]];
        preIndex[0]++;
        TreeNode<Integer> root = new TreeNode<>(curr);
        if (left == right) {
            return root;
        }
        int inIndex = map.get(curr);
        root.left = buildTree(pre, in, map, left, inIndex - 1, preIndex);
        root.right = buildTree(pre, in, map, inIndex + 1, right, preIndex);
        return root;

    }
    public static void main(String[] args) {
        int[][] pOrder = {
                {3, 9, 20, 15, 7},
                {-1},
                {10, 20, 40, 50, 30, 60},
                {1, 2, 4, 5, 3, 6},
                {1, 2, 4, 7, 3},
                {1, 2, 4, 8, 9, 5, 3, 6, 7}
        };

        int[][] iOrder = {
                {9, 3, 15, 20, 7},
                {-1},
                {40, 20, 50, 10, 60, 30},
                {4, 2, 5, 1, 6, 3},
                {4, 2, 7, 1, 3},
                {8, 4, 9, 2, 5, 1, 6, 3, 7}
        };

        int index = 0;
        for (int i = 0; i < pOrder.length; i++) {
            System.out.println((index + 1) + ".\tPre order: " + Arrays.toString(pOrder[index]));
            System.out.println("\tIn order: " + Arrays.toString(iOrder[index]));
            TreeNode<Integer> tree = buildTree(pOrder[index], iOrder[index]);
            index++;
            System.out.println("\n\tBinary tree:");
            //Print.displayTree(tree);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
