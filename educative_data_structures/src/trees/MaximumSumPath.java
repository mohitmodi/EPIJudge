package trees;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumPath {
    int maxSum = Integer.MIN_VALUE;


    public static void main(String args[]) {
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(-8), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(-1), new TreeNode<Integer>(-3)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), new TreeNode<Integer>(30), new TreeNode<Integer>(16), new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(0)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), null, null, new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(-3), new TreeNode<Integer>(3), new TreeNode<Integer>(5), null, null, new TreeNode<Integer>(-5))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        MaximumSumPath sol = new MaximumSumPath();
        int i = 0;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println((i + 1) + ".\tBinary Tree");
            //Print.displayTree(tree.root);
            i++;
            System.out.println("\n\tMaximum path sum: " + sol.maxPathSum(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private int maxPathSum(TreeNode<Integer> root) {
        maxSum = Integer.MIN_VALUE;
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int maxLeft = this.maxSum(root.left);
        int maxRight = this.maxSum(root.right);
        int leftSubtree = 0;
        int rightSubtree = 0;

        if (maxLeft > 0)
            leftSubtree = maxLeft;

        if (maxRight > 0)
            rightSubtree = maxRight;

        int valueNewpath = root.data + leftSubtree + rightSubtree;
        maxSum = Math.max(maxSum, valueNewpath);
        return root.data + Math.max(leftSubtree, rightSubtree);

    }
}
