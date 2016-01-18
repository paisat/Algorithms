package tree;

/**
 * Created by sarvothampai on 24/10/15.
 */
public class CheckIfABinaryTreeIsAFullTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        CheckIfABinaryTreeIsAFullTree obj = new CheckIfABinaryTreeIsAFullTree();

        System.out.println(obj.isFullBinaryTree(root));
    }


    public boolean isFullBinaryTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {

            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);

        }

        return false;
    }
}
