package bigbubuclass;

import com.sun.source.tree.Tree;

import java.util.*;

public class BTRightMostNodeAtEachLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;


        InvertTree.printTree(root, 2);
        System.out.println(rightMostNode(root));
    }

    private static List<Integer> rightMostNode(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            for (int i = 0; i < currQueueSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (i == currQueueSize - 1) {
                    res.add(curr.data);
                }
            }

        }
        return res;
    }
}
