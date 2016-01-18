package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Given a Binary Tree, find the maximum sum path from a leaf to root. For example, in the following tree, there are three leaf to root paths 8->-2->10, -4->-2->10 and 7->10. The sums of these three paths are 16, 4 and 17 respectively. The maximum of them is 17 and the path for maximum is 7->10.
 * <p/>
 * 10
 * /      \
 * -2        7
 * /   \
 * 8     -4
 * <p/>
 * Solution
 * 1) First find the leaf node that is on the maximum sum path. In the following code getTargetLeaf() does this by assigning the result to *target_leaf_ref.
 * 2) Once we have the target leaf node, we can print the maximum sum path by traversing the tree. In the following code, printPath() does this.
 * <p/>
 * The main function is maxSumPath() that uses above two functions to get the complete solution.
 * <p/>
 * <p/>
 *
 * Time Complexity : O(N)
 */


class MaxSumRootToLeafPath {

    public static void main(String[] args) {

        MaxSumRootToLeafPath obj = new MaxSumRootToLeafPath();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right = new TreeNode(7);

        List<TreeNode> result = obj.getMaxSumPath(root);

        for (TreeNode node : result) {
            System.out.println(node.val);
        }


    }


    public List<TreeNode> getMaxSumPath(TreeNode root) {

        List<TreeNode> result = new ArrayList<TreeNode>();


        if (root != null) {

            TreeNode[] targetLeaf = new TreeNode[1];
            targetLeaf[0] = null;
            Integer maxSum[] = new Integer[1];
            maxSum[0] = null;

            getMaxSumLeafNode(root, 0, targetLeaf, maxSum);

            if (targetLeaf[0] != null) {
                getPath(root, result, targetLeaf[0]);
            }

        }


        return result;

    }

    private boolean getPath(TreeNode root, List<TreeNode> path, TreeNode target) {

        if (root == null) {
            return false;
        }

        if (root == target || getPath(root.left, path, target) || getPath(root.right, path, target)) {
            path.add(root);
            return true;
        }

        return false;
    }

    private void getMaxSumLeafNode(TreeNode root, int sum, TreeNode[] result, Integer[] maxSum) {

        if (root == null) {
            return;
        }

        sum = sum + root.val;

        if (root.left == null && root.right == null) {

            if (maxSum[0] == null) {
                result[0] = root;
                maxSum[0] = root.val;

            } else {
                if (maxSum[0] < sum) {
                    result[0] = root;
                    maxSum[0] = sum;
                }
            }

            return;

        }

        getMaxSumLeafNode(root.left, sum, result, maxSum);
        getMaxSumLeafNode(root.right, sum, result, maxSum);

    }
}