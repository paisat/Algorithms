package tree;

/**
 * Created by sarvothampai on 07/10/15.
 * <p/>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p/>
 * Initially, all next pointers are set to NULL.
 * <p/>
 * Note:
 * <p/>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * <p/>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 *
 *
 * Time Complexity : O(N)
 *
 */
public class PopulateNextPointersInBinaryTreeFullBinaryTree {


    public void connect(TreeLinkNode root) {


        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = (root.next != null) ? root.next.left : null;
        }

        connect(root.left);
        connect(root.right);

    }
}
