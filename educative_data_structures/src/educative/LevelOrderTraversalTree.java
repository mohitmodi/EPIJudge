package educative;

import java.util.*;
import java.util.LinkedList;

public class LevelOrderTraversalTree {


    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currLayerSize = queue.size();
            List<Integer> currLayer = new ArrayList<>();
            for (int i = 0; i < currLayerSize; i++) {
                TreeNode<Integer> curr = queue.poll();
                currLayer.add(curr.data);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                res.add(currLayer);

            }
        }
        return res;

    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
//100 : 50, 200 : 25, 75, 350

    public static String levelOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return "None";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<String> currList = new ArrayList<>();
            int currQueueSize=queue.size();
            for (int i = 0; i < currQueueSize; i++) {
                TreeNode<Integer> curr = queue.poll();
                currList.add(String.valueOf(curr.data));
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            stringBuilder.append(String.join(", ", currList));
            if(!queue.isEmpty())
            stringBuilder.append(" : ");
        }
        return stringBuilder.toString();
    }

}
