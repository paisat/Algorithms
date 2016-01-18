package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Time Complexity : O(N)
 */


public class PostOrderSucessorOfBinaryTree {

    public static void main(String[] args) {

        PostOrderSucessorOfBinaryTree obj = new PostOrderSucessorOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);


        TreeNode successor = obj.findPostOrderSucessor(root, new TreeNode(1212), new boolean[] { false });


        if (successor != null) {
            System.out.println(successor.val);
        }

    }


    public TreeNode findPostOrderSucessor(TreeNode root, TreeNode node, boolean[] found) {

        TreeNode succ = null;

        if (root == null) {
            return null;
        }

        succ = findPostOrderSucessor(root.left, node, found);

        if (succ != null) {
            return succ;
        }

        succ = findPostOrderSucessor(root.right, node, found);

        if (succ == null && found[0]) {
            return root;
        }

        if (root.val == node.val) {
            found[0] = true;
        }

        return succ;

    }
}
