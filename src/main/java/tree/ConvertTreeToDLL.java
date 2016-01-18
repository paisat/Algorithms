package tree;

/**
 * Created by sarvothampai on 24/10/15.
 */
public class ConvertTreeToDLL {


    private TreeNode prev;

    public static void main(String[] args) {

        ConvertTreeToDLL obj = new ConvertTreeToDLL();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(36);

        TreeNode treeNode = obj.convertTree(root);

        TreeNode cur = treeNode;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }

        System.out.println();

        TreeNode cur2 = treeNode;

        while (cur2 != null && cur2.right != null) {
            cur2 = cur2.right;
        }

        while (cur2 != null) {
            System.out.print(cur2.val + " ");
            cur2 = cur2.left;
        }

        System.out.println();


    }

    public TreeNode convertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        fixLeftPointer(root);

        while (root != null && root.right != null) {
            root = root.right;
        }


        TreeNode previous = null;

        while (root != null && root.left != null) {

            previous = root;
            root = root.left;
            root.right = previous;
        }

        return root;
    }


    private void fixLeftPointer(TreeNode root) {

        if (root != null) {

            fixLeftPointer(root.left);
            root.left = prev;
            prev = root;
            fixLeftPointer(root.right);

        }

    }


}
