package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * <p/>
 * To find the preorder predecessor of node u:
 * If u is the root of the tree, then pred(u) is undefined
 * If u has a left sibling, ls, then pred(u) is the rightmost descendent of ls Otherwise, pred(u) is parent(u).
 * <p/>
 * Time Complexity : O(N)
 */
public class FindPreOrderPredecessor {

    public static void main(String[] args) {

        FindPreOrderPredecessor obj = new FindPreOrderPredecessor();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        root.left.right.right = new TreeNode(6);

        TreeNode pred = obj.findPreOrderPredecessor(root, new TreeNode(2), null, null);

        if (pred != null) {
            System.out.println(pred.val);
        }


    }


    public TreeNode findPreOrderPredecessor(TreeNode root, TreeNode value, TreeNode leftSibling, TreeNode parent) {

        if (root == null) {
            return null;

        }

        TreeNode pred;

        if (root.val == value.val) {

            if (leftSibling != null) {
                TreeNode cur = leftSibling;
                while (cur.right != null) {
                    cur = cur.right;
                }

                return cur;
            } else {
                return parent;
            }

        }


        pred = findPreOrderPredecessor(root.left, value, null, root);

        if (pred != null) {
            return pred;
        }

        pred = findPreOrderPredecessor(root.right, value, root.left, root);

        return pred;

    }

}
