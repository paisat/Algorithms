package tree;

/**
 * Created by sarvothampai on 08/10/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class CheckIfATreeISBST {


    public static void main(String[] args) {

        CheckIfATreeISBST obj = new CheckIfATreeISBST();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        //root.right = new TreeNode(15);

//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);

        System.out.println(obj.isValidBST(root));

    }

    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {


        return checkBST(root);


    }

    private boolean checkBST(TreeNode root) {


        if (root == null) {
            return true;
        }

        boolean result = true;

        if (result ) {
            result = checkBST(root.left);
        }


        if (prev != null && prev.val >= root.val) {

            return false;
        }

        if (prev == null) {
            prev = new TreeNode(root.val);
        } else {
            prev.val = root.val;
        }


        if (result ) {
            result = checkBST(root.right);
        }


        return result;


    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
