package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Given a complete binary tree, count the number of nodes.
 * <p/>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p/>
 * Subscribe to see which companies asked this question.
 * <p/>
 * Time Complexity : O(log n)^2
 */
public class CountCompleteTreeNodes {


    private int height(TreeNode root) {

        if (root == null) {
            return -1;
        }

        return 1 + height(root.left);

    }

    public int countNodes(TreeNode root) {

        int nodes = 0;

        if (root != null) {

            int height = height(root);

            while (root != null) {

                if (height(root.right) == height - 1) {
                    nodes = nodes + (1 << height);
                    root = root.right;
                } else {

                    nodes = nodes + (1 << height - 1);
                    root = root.left;
                }

                height--;

            }

        }

        return nodes;

    }

}
