package tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by sarvothampai on 24/10/15.
 *
 * Given a Binary Tree, we need to print the bottom view from left to right.
 * A node x is there in output if x is the bottommost node at its horizontal distance.
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
 * and that of right child is horizontal distance of x plus 1.

 Examples:

      20
    /    \
    8     22
  /   \      \
 5      3      25
 / \
 10    14

 For the above tree the output should be 5, 10, 3, 14, 25.


        20
      /     \
    8         22
 /   \       /   \
 5      3   4     25
        / \
     10    14


 Time Complexity : O(N)


 For the above tree the output should be 5, 10, 4, 14, 25.
 */
public class BottomViewOfBinaryTree {


    public static void main(String[] args) {


        BottomViewOfBinaryTree obj = new BottomViewOfBinaryTree();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right.right = new TreeNode(25);

        obj.BottomViewOfBinaryTree(root);


    }


    public void BottomViewOfBinaryTree(TreeNode root) {

        if (root == null) {
            return;
        }



        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Queue<Integer> hdQueue = new ArrayDeque<Integer>();

        TreeMap<Integer, TreeNode> resultSet = new TreeMap<Integer, TreeNode>();

        int hd = 0;

        queue.add(root);
        hdQueue.add(hd);

        resultSet.put(hd, root);


        while (!queue.isEmpty()) {


            int hDistance = hdQueue.poll();

            TreeNode node = queue.poll();

            if (node.left != null) {

                queue.add(node.left);
                hdQueue.add(hDistance - 1);
                resultSet.put(hDistance - 1, node.left);

            }

            if (node.right != null) {

                queue.add(node.right);
                hdQueue.add(hDistance + 1);
                resultSet.put(hDistance + 1, node.right);
            }


        }

        for (Map.Entry<Integer, TreeNode> v : resultSet.entrySet()) {

            System.out.println(v.getValue().val);

        }


    }

}
