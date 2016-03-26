package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * <p/>
 * Time complexity : O(N)
 * <p/>
 * Space Complexity :O(N)
 */


public class IterativeTreeHeight {


    public static void main(String[] args) {


        IterativeTreeHeight obj = new IterativeTreeHeight();


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(obj.getHeight(root));

    }


    public int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            height++;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);

                }

            }

        }

        return height;


    }
}
