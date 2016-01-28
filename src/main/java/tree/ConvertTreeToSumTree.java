package tree;

/**
 * Created by sarvothampai on 29/12/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class ConvertTreeToSumTree {


    public static void main(String[] args) {

        ConvertTreeToSumTree obj = new ConvertTreeToSumTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);

        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        obj.convertTreeToSumTree(root);
        obj.printInorder(root);


    }

    private void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);

    }

    public void convertTreeToSumTree(TreeNode root) {
        if (root != null) {
            convertTreeHelper(root);
        }
    }


    private int convertTreeHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int oldVal = root.val;

        root.val = convertTreeHelper(root.left) + convertTreeHelper(root.right);

        return oldVal + root.val;

    }

}
