package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 11/10/15.
 * <p/>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <p/>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p/>
 * <p/>
 * The flattened tree should look like:
 * <p/>
 * <p/>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * Time Complexity : O(N)
 *
 */
public class FlattenBTToLinkedList {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;

        while (cur != null || !stack.empty()) {

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                cur.right = cur.left;
                cur.left = null;
            } else if (!stack.empty()) {
                TreeNode node = stack.pop();
                cur.right = node;
            }

            cur = cur.right;
        }

    }
}
