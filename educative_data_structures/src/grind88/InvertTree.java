package grind88;

import com.sun.source.tree.Tree;

import java.util.*;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        left.left.left = new TreeNode(8);
        left.right.right = new TreeNode(9);
        right.left.right = new TreeNode(10);
        right.right.left = new TreeNode(11);
        System.out.println("orig" + zigzag(root));
        System.out.println("new" + zigzag(invertTree(root)));


    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static List<Integer> zigzag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        if (root != null) {
            queue.add(root);
            visited.add(root);
        }
        int counter = 0;
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = queue.poll();
                res.add(curr.data);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            result.addAll(res);

        }
        return result;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

