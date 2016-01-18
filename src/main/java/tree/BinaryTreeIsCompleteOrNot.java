package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Check if a binary tree is complete or not.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class BinaryTreeIsCompleteOrNot {


    public static void main(String[] args) {

        BinaryTreeIsCompleteOrNot obj = new BinaryTreeIsCompleteOrNot();

        TreeNode root1 = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(5);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.right = new TreeNode(3);


        System.out.println(obj.isTreeComplete(root1));
        System.out.println(obj.isTreeComplete(root2));

        System.out.println(obj.isTreeCompleteLevelOrder(root1));
        System.out.println(obj.isTreeCompleteLevelOrder(root2));

        root2.right.right = new TreeNode(34);
        System.out.println(obj.isTreeComplete(root2));
        System.out.println(obj.isTreeCompleteLevelOrder(root2));
        System.out.println(obj.isTreeCompleteLevelOrder(root3));


    }

    public boolean isTreeComplete(TreeNode root) {


        return isTreeACompleteTree(root, 0, countNumberOfNode(root));

    }

    public boolean isTreeCompleteLevelOrder(TreeNode root) {


        if (root == null) {
            return true;
        }


        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        boolean incompleteNodeFound = false;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {

                if (incompleteNodeFound) {
                    return false;
                }

                queue.add(node.left);
            } else {
                incompleteNodeFound = true;
            }


            if (node.right != null) {

                if (incompleteNodeFound) {
                    return false;
                }

                queue.add(node.right);
            } else {
                incompleteNodeFound = true;
            }

        }

        return true;
    }


    private boolean isTreeACompleteTree(TreeNode root, int index, int numberOfNodes) {

        if (root == null) {
            return true;
        }

        if (index >= numberOfNodes) {
            return false;
        }

        return isTreeACompleteTree(root.left, 2 * index + 1, numberOfNodes) && isTreeACompleteTree(root.right, 2 * index + 2, numberOfNodes);

    }

    private int countNumberOfNode(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNumberOfNode(root.left) + countNumberOfNode(root.right);

    }
}
