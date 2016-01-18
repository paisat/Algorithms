package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 06/10/15.
 */
public class IterativePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preTrav = new ArrayList<Integer>();

        if (root != null) {

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);

            while (!stack.isEmpty()) {

                TreeNode current = stack.pop();
                preTrav.add(current.val);

                if (current.right != null) {
                    stack.push(current.right);

                }

                if (current.left != null) {
                    stack.push(current.left);
                }

            }
        }

        return preTrav;
    }
}
