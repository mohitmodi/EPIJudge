package trees;

import trees.BinaryTree;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidBST {
    public static void main(String args[]) {
            List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                    Arrays.asList(new TreeNode<Integer>(4), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(5),new TreeNode<Integer>(6),new TreeNode<Integer>(9))
                    //Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(7)),
                    //Arrays.asList(new TreeNode<Integer>(4), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                    //Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(8)),
                    //Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                    //Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(4), null, new TreeNode<Integer>(9))
            );

            List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
            for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
                BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
                inputTrees.add(tree);
            }

            int x = 1;
            for (BinaryTree<Integer> tree : inputTrees) {
                System.out.println(x + ".\tInput Tree:");
                //Print.displayTree(tree.root);
                x++;
                System.out.println("\n\tValid BST: " + validBST(tree.root));
                System.out.println(new String(new char[100]).replace('\0', '-'));
            }
        }

    private static boolean validBST(TreeNode<Integer> root) {

        return validate(root);

    }

    private static boolean validate(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        return  root.data > root.left.data && root.data <= root.right.data && validate(root.left) && validate(root.right);
    }
}
