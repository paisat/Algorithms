package tree;

/**
 * Created by sarvothampai on 24/10/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class TwoNodesOfBSTAreSwappedRecoverBST {

    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;


    public static void main(String[] args) {

        TwoNodesOfBSTAreSwappedRecoverBST obj = new TwoNodesOfBSTAreSwappedRecoverBST();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);

        obj.recoverTree(root);


    }

    public void recoverTree(TreeNode root) {


        correctTree(root);

        if (first != null && middle != null && last == null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }


    }

    private void correctTree(TreeNode root) {

        if (root == null) {
            return;
        }

        correctTree(root.left);

        if (prev != null && prev.val > root.val) {

            if (first == null && middle == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;


        correctTree(root.right);


    }
}
