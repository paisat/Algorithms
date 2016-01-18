package tree;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 *
 * Time complexity : O(N)
 *
 */
public class UpSideDownBinaryTree {


    public TreeNode UpsideDownBinaryTree(TreeNode root) {

        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode next = null;

        while (cur != null) {

            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;

        }

        return prev;


    }

}
