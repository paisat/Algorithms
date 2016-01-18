package tree;

/**
 * Created by sarvothampai on 06/10/15.
 * <p/>
 * Check if a Binary tree has root to sum path equal to a given sum.
 * <p/>
 *
 * PitFalls:
 *
 * Check left and right nodes for null before traversing;
 *
 *
 * Time Complexity: O(N)
 */
public class BinaryTreeHasRootToLeafSumPath {

    public boolean hasPathSum(TreeNode root, int sum) {


        if (root == null) {
            return false;
        }

        int subSum = sum - root.val;

        if (subSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean ans = false;

        if (root.left != null) {
            ans = ans || hasPathSum(root.left, subSum);
        }

        if (root.right != null) {
            ans = ans || hasPathSum(root.right, subSum);
        }

        return ans;


    }
}
