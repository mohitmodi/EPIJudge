package educative;

public class DiamOfTree {
    public static int diamOfTree(TreeNode<Integer> root) {
        RecursiveAnser ra = diamOfTreeHelper(root);
        return ra.maxDiamSoFar;
    }

    private static RecursiveAnser diamOfTreeHelper(TreeNode<Integer> root) {
        if (root == null) {
            return new RecursiveAnser(0, 0);
        }
        RecursiveAnser lh = diamOfTreeHelper(root.left);
        RecursiveAnser rh = diamOfTreeHelper(root.right);
        int maxHeight = Math.max(lh.height, rh.height) + 1;
        int maxDiam = Math.max(lh.maxDiamSoFar, Math.max(rh.maxDiamSoFar, lh.height + rh.height));
        return new RecursiveAnser(maxHeight, maxDiam);
    }

}

class RecursiveAnser {
    int height;
    int maxDiamSoFar;

    RecursiveAnser(int height, int maxDiamSoFar) {
        this.height = height;
        this.maxDiamSoFar = maxDiamSoFar;
    }
}
