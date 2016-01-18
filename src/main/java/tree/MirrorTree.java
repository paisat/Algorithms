package tree;

/**
 * Created by sarvothampai on 16/12/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class MirrorTree {

    public void mirrorTree(TreeNode root) {

        if (root == null) {
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}
