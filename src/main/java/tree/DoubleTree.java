package tree;

/**
 * Created by sarvothampai on 21/12/15.
 * <p/>
 * Write a program that converts a given tree to its Double tree. To create Double tree of the given tree, create a new duplicate for each node, and insert the duplicate as the left child of the original node.
 * <p/>
 * So the tree…
 * <p/>
 * 2
 * / \
 * 1   3
 * is changed to…
 * <p/>
 * 2
 * / \
 * 2   3
 * /   /
 * 1   3
 * /
 * 1
 * And the tree
 * <p/>
 * 1
 * /   \
 * 2      3
 * /  \
 * 4     5
 * is changed to
 * <p/>
 * 1
 * /   \
 * 1      3
 * /      /
 * 2       3
 * /  \
 * 2    5
 * /    /
 * 4   5
 * /
 * 4
 */

public class DoubleTree {

    public void doubleTree(TreeNode root) {

        if (root == null) {
            return;
        }

        doubleTree(root.left);
        doubleTree(root.right);

        TreeNode temp = root.left;
        root.left = new TreeNode(root.val);
        root.left.left = temp;
    }

}
