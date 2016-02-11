package tree;

/**
 * Created by sarvothampai on 22/12/15.
 *
 * Check if a given Binary Tree is SumTree
 Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

 Following is an example of SumTree.

     26
    /   \
    10     3
     /    \     \
     4      6      3

 *
 */

public class SumTree {


    public static void main(String[] args) {

        SumTree obj = new SumTree();

        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(3);

        System.out.println(obj.isSumTree(root));
        System.out.println(obj.isSumTree2nd(root));

    }


    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + root.val + sum(root.right);
    }

    /**
     * Time Complexity : O(N^2)
     */
    public boolean isSumTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        if (root.val == left + right && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }

        return false;

    }

    public boolean isLeaf(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return false;
    }


    /**
     * Time Complexity : O(N)
     */
    public boolean isSumTree2nd(TreeNode root) {

        if (root == null || isLeaf(root)) {
            return true;
        }

        if (isSumTree2nd(root.left) && isSumTree2nd(root.right)) {
            int ls;
            int rs;

            if (root.left == null) {
                ls = 0;
            } else if (isLeaf(root.left)) {
                ls = root.left.val;
            } else {
                ls = 2 * root.left.val;
            }

            if (root.right == null) {
                rs = 0;
            } else if (isLeaf(root.right)) {
                rs = root.right.val;
            } else {
                rs = 2 * root.right.val;
            }

           return root.val == ls + rs;

        }

        return false;

    }


}
