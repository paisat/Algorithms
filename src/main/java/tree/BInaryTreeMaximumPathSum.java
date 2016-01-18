package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 24/10/15.
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

     1
    / \
    2  3
 Return 6.


 Time Complexity : O(N)

 *
 */
public class BInaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        int arr[] = { Integer.MIN_VALUE };

        calculateMaxPathSum(root, arr);

        return arr[0];

    }

    private int calculateMaxPathSum(TreeNode root, int arr[]) {

        if (root == null) {
            return 0;
        }

        int l = calculateMaxPathSum(root.left, arr);
        int r = calculateMaxPathSum(root.right, arr);

        int current = Math.max(root.val, Math.max(root.val + l, root.val + r));

        arr[0] = Math.max(arr[0], Math.max(current, root.val + l + r));

        return current;

    }

}
