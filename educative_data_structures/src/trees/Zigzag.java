package trees;

import java.util.*;

public class Zigzag {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        Deque<TreeNode<Integer>> dequeue = new LinkedList<>();
        dequeue.add(root);
        boolean flag = false;

        while (!dequeue.isEmpty()) {
            int size = dequeue.size();
            results.add(new ArrayList<Integer>());

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node;
                if (flag) {
                    node = dequeue.pollFirst();
                    results.get(results.size() - 1).add(node.data);

                } else {
                    node = dequeue.pollLast();
                    results.get(results.size() - 1).add(node.data);
                }
                if (node.right != null) {
                    dequeue.add(node.right);
                }
                if (node.left != null) {
                    dequeue.add(node.left);
                }
            }
            flag = !flag;


        }


        return results;
    }

    public static void main(String args[]) {
        List<List<TreeNode<Integer>>> lists = Arrays.asList(

                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(200), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25)),
                Arrays.asList(new TreeNode<Integer>(100)),
                Arrays.asList(new TreeNode<Integer>(null))
        );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
            //Print.displayTree(t.root);
            System.out.println("\n\t The zigzag level order traversal is: " + zigzagLevelOrder(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
