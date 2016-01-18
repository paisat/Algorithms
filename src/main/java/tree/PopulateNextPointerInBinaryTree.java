package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * <p/>
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p/>
 * Note:
 * <p/>
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 *
 * Time Complexity : O(N)
 */
public class PopulateNextPointerInBinaryTree {

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        TreeLinkNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }

            if (cur.right != null) {
                cur.right.next = getNext(cur);
            }
            cur = cur.next;
        }

        connect(root.left);
        connect(root.right);

    }


    private TreeLinkNode getNext(TreeLinkNode root) {

        TreeLinkNode cur = root.next;

        while (cur != null) {

            if (cur.left != null) {
                return cur.left;
            }

            if (cur.right != null) {
                return cur.right;
            }

            cur = cur.next;

        }

        return null;

    }
}
