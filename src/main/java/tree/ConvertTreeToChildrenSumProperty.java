package tree;

/**
 * Created by sarvothampai on 16/12/15.
 * <p/>
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 * Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node).
 * <p/>
 * For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.
 * <p/>
 * <p/>
 * Time Complexity is O(N^2)
 */
public class ConvertTreeToChildrenSumProperty {


    public void convertTreeToSumTree(TreeNode root) {


        if (root == null || (root.left == null && root.right == null)) {
            return;
        }


        convertTreeToSumTree(root.left);
        convertTreeToSumTree(root.right);

        int leftData = (root.left != null) ? root.left.val : 0;

        int rightData = (root.right != null) ? root.right.val : 0;

        int diff = (leftData + rightData) - root.val;

        if (diff > 0) {
            root.val = root.val + diff;
        } else if (diff < 0) {
            increment(root, Math.abs(diff));
        }


    }

    private void increment(TreeNode root, int diff) {

        if (root.left != null) {
            root.left.val = root.left.val + diff;

            increment(root.left, diff);
        } else if (root.right != null) {
            root.right.val = root.right.val + diff;
            increment(root.right, diff);
        }

    }

}
