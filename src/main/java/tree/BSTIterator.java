package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 14/10/15.
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {

        if (hasNext()) {

            TreeNode cur = stack.pop();
            int element = cur.val;

            cur = cur.right;

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            return element;
        }

        return 0;

    }
}
