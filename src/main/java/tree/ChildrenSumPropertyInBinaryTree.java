package tree;

/**
 * Created by sarvothampai on 16/12/15.
 *
 * Given a binary tree, write a function that returns true if the tree satisfies below property.

 For every node, data value must be equal to sum of data values in left and right children.
 Consider data value as 0 for NULL children. Below tree is an example
 *
 */
public class ChildrenSumPropertyInBinaryTree {

    public boolean doesTreeHasChildrenSumProperty(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftData = (root.left != null) ? root.left.val : 0;

        int rightData = (root.right != null) ? root.right.val : 0;

        if (root.val == leftData + rightData && doesTreeHasChildrenSumProperty(root.left) && doesTreeHasChildrenSumProperty(root.right)) {
            return true;
        }

        return false;
    }

}
