package tree;

/**
 * Created by sarvothampai on 16/12/15.
 * <p/>
 * <p/>
 * <p/>
 * Find Minimum Depth of a binary tree
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class MinimumDepthOfABinaryTree {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }
}
