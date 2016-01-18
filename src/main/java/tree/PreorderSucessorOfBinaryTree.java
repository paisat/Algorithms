package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Time Complexity : O(N)
 *
 *
 */
public class PreorderSucessorOfBinaryTree {

    public static void main(String[] args) {

        PreorderSucessorOfBinaryTree obj = new PreorderSucessorOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        root.left.right.right = new TreeNode(6);

        TreeNode successor = obj.findPreOrderSucessor(root, new TreeNode(332), new boolean[] { false });


        if (successor != null) {
            System.out.println(successor.val);
        }

    }


    public TreeNode findPreOrderSucessor(TreeNode root, TreeNode node, boolean[] found) {

        TreeNode succ = null;

        if (root == null) {
            return null;
        }

        if (found[0]) {
            return root;
        }

        if (root.val == node.val) {
            found[0] = true;
        }

        succ = findPreOrderSucessor(root.left, node, found);

        if (succ != null) {
            return succ;
        }

        succ = findPreOrderSucessor(root.right, node, found);

        return succ;

    }


}
