package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * To find the inorder predecessor of node u
 * If u has a left child, l, then pred(u) is the rightmost descendent of l
 * Otherwise, pred(u) is the closest ancestor, v, of u (if any) such that u is de- scended from the right child of v.
 * If there is no such ancestor, then pred(u) is undefined.
 * <p/>
 * Time Complexity : O(N)
 */
public class FindInOrderPredecessorOfBinaryTree {


    public static void main(String[] args) {

        FindInOrderPredecessorOfBinaryTree obj = new FindInOrderPredecessorOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);

        TreeNode predecessor = obj.inOrderPredecessorOfBinaryTree(root, new TreeNode(4), new TreeNode(0));

        if (predecessor != null) {
            System.out.println(predecessor.val);
        }

    }


    public TreeNode inOrderPredecessorOfBinaryTree(TreeNode root, TreeNode node, TreeNode rightParent) {


        if (root == null) {
            return null;
        }

        TreeNode pred;

        pred = inOrderPredecessorOfBinaryTree(root.left, node, rightParent);

        if (pred != null) {
            return pred;
        }

        if (root.val == node.val) {
            if (root.left != null) {
                TreeNode cur = root.left;
                while (cur != null && cur.right != null) {
                    cur = cur.right;
                }
                return cur;
            } else {
                return rightParent.right;
            }
        }


        rightParent.right = root;
        pred = inOrderPredecessorOfBinaryTree(root.right, node, rightParent);

        return pred;


    }
}
