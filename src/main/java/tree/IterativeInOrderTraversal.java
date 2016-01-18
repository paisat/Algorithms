package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 06/10/15.
 *
 * Time Complexity : O(N)
 */
public class IterativeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inOrder = new ArrayList<Integer>();

        if (root != null) {

            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            boolean done = false;

            while (!done) {

                if (current != null) {

                    stack.push(current);
                    current = current.left;
                } else {

                    if (!stack.isEmpty()) {
                        current = stack.pop();
                        inOrder.add(current.val);
                        current = current.right;
                    } else {
                        done = true;
                    }
                }

            }


        }

        return inOrder;


    }
}
