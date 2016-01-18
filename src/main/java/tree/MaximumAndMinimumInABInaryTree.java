package tree;

/**
 * Created by sarvothampai on 24/10/15.
 */
public class MaximumAndMinimumInABInaryTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(50);
        root.right = new TreeNode(105);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(65);

        root.left.right.left = new TreeNode(52);
        root.left.right.left.right = new TreeNode(57);


        MaximumAndMinimumInABInaryTree obj = new MaximumAndMinimumInABInaryTree();

        System.out.println(obj.maximumInABinaryTree(root));
        System.out.println(obj.minimumInABinaryTree(root));


    }


    public int maximumInABinaryTree(TreeNode root) {


        if (root == null) {
            return Integer.MIN_VALUE;
        }



        int l = maximumInABinaryTree(root.left);
        int r = maximumInABinaryTree(root.right);

        int res = root.val;

        if (l > res) {
            res = l;
        }

        if (r > res) {
            res = r;

        }

        return res;

    }

    public int minimumInABinaryTree(TreeNode root) {


        if (root == null) {
            return Integer.MAX_VALUE;
        }



        int l = minimumInABinaryTree(root.left);
        int r = minimumInABinaryTree(root.right);

        int res = root.val;

        if (l < res) {
            res = l;
        }

        if (r < res) {
            res = r;

        }

        return res;

    }


}
