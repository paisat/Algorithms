package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 06/10/15.
 *
 * Time Complexity : O(N)
 */
public class BinaryTreeHeight {

    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        return 1+(Math.max(maxDepth(root.left),maxDepth(root.right)));

    }
}
