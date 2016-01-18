package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sarvothampai on 15/10/15.
 *
 * Time Complexity : O(N)
 */
public class RightSideView {

    public static void main(String[] args) {

        RightSideView obj = new RightSideView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> rightSideView = obj.rightSideView(root);

        for (Integer i : rightSideView) {
            System.out.println(i);
        }

    }


    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightSideView = new ArrayList<Integer>();

        if (root != null) {

            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

            TreeNode cur = root;
            queue.add(cur);

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int i = 0; i < size; i++) {

                    TreeNode node = queue.remove();

                    if (i == 0) {
                        rightSideView.add(node.val);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }


                }


            }


        }

        return rightSideView;

    }
}
