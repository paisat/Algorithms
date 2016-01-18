package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * Given a binary tree, print the top view of it.
 * The output nodes can be printed in any order. Expected time complexity is O(n)
 * <p/>
 * A node x is there in output if x is the topmost node at its horizontal distance.
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 * 1
 * /     \
 * 2       3
 * /  \    / \
 * 4    5  6   7
 * Top view of the above binary tree is
 * 4 2 1 3 7
 * <p/>
 * 1
 * /   \
 * 2       3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p/>
 * Top view of the above binary tree is
 * 2 1 3 6
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */


public class TopViewOfBinaryTree {

    public static void main(String[] args) {

        TopViewOfBinaryTree obj = new TopViewOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.right = new TreeNode(4);
        root1.left.right.right = new TreeNode(5);
        root1.left.right.right.right = new TreeNode(6);

        System.out.println(obj.getTopView(root));
        System.out.println(obj.getTopView(root1));


    }


    public List<Integer> getTopView(TreeNode root) {

        List<Integer> topView = new ArrayList<Integer>();

        if (root != null) {


            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            Queue<Integer> hdQueue = new ArrayDeque<Integer>();

            Set<Integer> set = new HashSet<Integer>();

            queue.add(root);
            hdQueue.add(0);

            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();
                int hd = hdQueue.poll();


                if (!set.contains(hd)) {
                    topView.add(node.val);
                    set.add(hd);
                }

                if (node.left != null) {
                    queue.add(node.left);
                    hdQueue.add(hd - 1);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    hdQueue.add(hd + 1);
                }


            }

        }

        return topView;

    }

}
