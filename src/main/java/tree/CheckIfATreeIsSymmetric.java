package tree;

/**
 * Created by sarvothampai on 10/10/15.
 * <p/>
 * Symmetric Tree (Mirror Image of itself)
 * Given a binary tree, check whether it is a mirror of itself.
 * <p/>
 * For example, this binary tree is symmetric:
 * 1
 * /   \
 * 2     2
 * / \   / \
 * 3   4 4   3
 * <p/>
 * <p/>
 * Note :
 * Same as foldable binary trees . In Foldable binary trees the tree has to be structutrally same.
 * Values need not be same.
 *
 * Time Complexity : O(N)
 *
 */
public class CheckIfATreeIsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        mirrorTree(root.left);

        boolean result = isTreeIdentical(root.left, root.right);

        mirrorTree(root.left);

        return result;

    }


    private boolean isTreeIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {

            return (root1.val == root2.val
                    && isTreeIdentical(root1.left, root2.left)
                    && isTreeIdentical(root1.right, root2.right));

        }

        return false;

    }

    private void mirrorTree(TreeNode root) {

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
