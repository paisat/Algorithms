package tree;

/**
 * Created by sarvothampai on 31/12/15.
 */
public class BinarySearchInsert {


    /**
     * Time Complexity : log(N)
     */
    public TreeNode deleteNode(TreeNode root, TreeNode nodeToBeDeleted) {

        if (root == null) {
            return root;
        }

        if (nodeToBeDeleted.val > root.val) {
            root.right = deleteNode(root.right, nodeToBeDeleted);
        } else if (nodeToBeDeleted.val < root.val) {
            root.left = deleteNode(root.left, nodeToBeDeleted);
        } else {


            if (root.left == null) {
                TreeNode temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                TreeNode temp = root.left;
                root = null;
                return temp;
            }

            TreeNode succ = getSucessor(root);
            root.val = succ.val;

            root.right = deleteNode(root.right, succ);
        }

        return root;
    }

    private TreeNode getSucessor(TreeNode root) {

        TreeNode succ = root.right;

        while (succ != null && succ.left != null) {
            succ = succ.left;
        }

        return succ;

    }

    public TreeNode insert(TreeNode root, TreeNode newNode) {

        if (root == null) {
            return newNode;
        }

        if (newNode.val > root.val) {
            root.right = insert(root.right, newNode);
        }

        if (newNode.val < root.val) {
            root.left = insert(root.left, newNode);
        }

        return root;
    }


    public TreeNode addNode(int data, TreeNode head) {
        TreeNode tempHead = head;
        TreeNode n = new TreeNode(data);
        if (head == null) {
            head = n;
            return head;
        }

        TreeNode prev = null;
        while (head != null) {
            prev = head;
            if (head.val < data) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        if (prev.val < data) {
            prev.right = n;
        } else {
            prev.left = n;
        }
        return tempHead;
    }


}
