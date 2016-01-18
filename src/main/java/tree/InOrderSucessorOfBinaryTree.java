package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Time Complexity : O(N)
 */
public class InOrderSucessorOfBinaryTree {


    public static void main(String[] args) {

        InOrderSucessorOfBinaryTree obj = new InOrderSucessorOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);

        TreeNode successor = obj.findInorderSucessor(root, new TreeNode(45), new boolean[] { false });


        if (successor != null) {
            System.out.println(successor.val);
        }

    }


    public TreeNode findInorderSucessor(TreeNode root, TreeNode node, boolean[] found) {

        TreeNode inOrder = null;

        if (root == null) {
            return null;
        }

        inOrder = findInorderSucessor(root.left, node, found);

        if (inOrder != null) {
            return inOrder;
        }

        if (found[0]) {
            return root;
        }

        if (root.val == node.val) {
            found[0] = true;
        }

        inOrder = findInorderSucessor(root.right, node, found);

        return inOrder;

    }

}
