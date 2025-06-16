package bigbubuclass;

import com.sun.source.tree.Tree;

import java.util.*;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(11);
        right.left = new TreeNode(2);
        left.right.right = new TreeNode(5);
        right.left.right = new TreeNode(9);
        printTree(root,5);
        printTree(invert(root),5);
    }
    public static void printTree(TreeNode root,int space) {
        int maxLevel = maxDepth(root);
        printNode(Collections.singletonList(root), 1, maxLevel);
    }
    private static void printNode(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);

                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    System.out.print(" ");

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    System.out.print(" ");

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printNode(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list)
            if (node != null) return false;
        return true;
    }

    public static TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}

