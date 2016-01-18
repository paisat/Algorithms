package tree;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). Note that the DLL need to be created in-place. Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. In DLL, left means previous pointer and right means next pointer.
 * <p/>
 * Let the following be input binary tree
 * 1
 * /     \
 * 2       3
 * / \       \
 * 4   5       6
 * / \         / \
 * 7   8       9   10
 * <p/>
 * <p/>
 * Output:
 * Doubly Linked List
 * 7<->8<->5<->9<->10
 * <p/>
 * Modified Tree:
 * 1
 * /     \
 * 2       3
 * /         \
 * 4           6
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class ExtractLeafList {

    public static void main(String[] args) {

        ExtractLeafList obj = new ExtractLeafList();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(9);

        TreeNode head = obj.extractLeafList(root);

        TreeNode cur = head;
        System.out.println();
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }

    }


    public TreeNode extractLeafList(TreeNode root) {

        if (root == null) {
            return root;
        }


        TreeNode[] head = new TreeNode[1];
        head[0] = null;
        extractLeafNodeHelper(root, head);
        return head[0];
    }

    private TreeNode extractLeafNodeHelper(TreeNode root, TreeNode[] head) {


        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            root.right = head[0];
            if (head[0] != null) {
                head[0].left = root;
            }

            head[0] = root;
            return null;

        }

        root.right = extractLeafNodeHelper(root.right, head);
        root.left = extractLeafNodeHelper(root.left, head);
        return root;

    }


}
