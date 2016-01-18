package tree;

/**
 * Created by sarvothampai on 01/01/16.
 *
 *
 * Time complexity : O(N)
 *
 */
public class SecondlargestElementInBst {

    public static void main(String[] args) {

        SecondlargestElementInBst obj = new SecondlargestElementInBst();
        TreeNode root = new TreeNode(137);
        root.right = new TreeNode(42);
        root.right.left = new TreeNode(99);

        TreeNode result = obj.getSecondLargest(root);

        if (result != null) {
            System.out.println(result.val);
        }

    }


    public TreeNode getSecondLargest(TreeNode root) {

        if (root == null) {
            return null;
        }
        return secondLargestHelper(root, new int[] { 2 });
    }


    private TreeNode secondLargestHelper(TreeNode root, int[] k) {

        if (root == null) {
            return null;
        }

        TreeNode result = secondLargestHelper(root.right, k);
        if (result != null) {
            return result;
        }

        k[0]--;
        if (k[0] == 0) {
            return root;
        }

        return secondLargestHelper(root.left, k);
    }

}
