package tree;

/**
 * Created by sarvothampai on 16/12/15.
 * <p/>
 * Time Complexity : O(N)
 */
public class CountLeafNodesInABinaryTree {

    public int countLeafNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeafNodes(root.left) + countLeafNodes(root.right);

    }
}
