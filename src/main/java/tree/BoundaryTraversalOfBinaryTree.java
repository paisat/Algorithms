package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example,
 * <p/>
 * boundary traversal of the following tree is “20 8 4 10 14 25 22″
 */


public class BoundaryTraversalOfBinaryTree {


    public static void main(String[] args) {

        BoundaryTraversalOfBinaryTree obj = new BoundaryTraversalOfBinaryTree();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        System.out.println(obj.getBoundaryTraversal(root));
    }


    List<Integer> getBoundaryTraversal(TreeNode root) {

        List<Integer> traversal = new ArrayList<Integer>();


        if (root != null) {

            traversal.add(root.val);
            printBoundaryLeft(root.left, traversal);

            printLeaves(root.left, traversal);
            printLeaves(root.right, traversal);

            printBoundaryRight(root.right, traversal);

        }


        return traversal;

    }

    private void printBoundaryLeft(TreeNode root, List<Integer> traversal) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            traversal.add(root.val);
            printBoundaryLeft(root.left, traversal);
        } else if (root.right != null) {
            traversal.add(root.val);
            printBoundaryRight(root.right, traversal);
        }

    }

    private void printBoundaryRight(TreeNode root, List<Integer> traversal) {

        if (root == null) {
            return;
        }

        if (root.right != null) {
            printBoundaryRight(root.right, traversal);
            traversal.add(root.val);
        } else if (root.left != null) {
            printBoundaryRight(root.left, traversal);
            traversal.add(root.val);
        }

    }

    private void printLeaves(TreeNode root, List<Integer> traversal) {

        if (root == null) {
            return;
        }

        printLeaves(root.left, traversal);

        if (root.left == null && root.right == null) {
            traversal.add(root.val);
        }

        printLeaves(root.right, traversal);

    }


}
