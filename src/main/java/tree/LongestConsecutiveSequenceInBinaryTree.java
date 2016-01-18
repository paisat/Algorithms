package tree;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p/>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p/>
 * For example,
 * <p/>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * <p/>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * <p/>
 * Time Complexity : O(N)
 */
public class LongestConsecutiveSequenceInBinaryTree {

    public static void main(String[] args) {

        LongestConsecutiveSequenceInBinaryTree obj = new LongestConsecutiveSequenceInBinaryTree();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        TreeNode root1 = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);
        root1.right.left.left = new TreeNode(1);

        System.out.println(obj.longestConsecutiveSequence(root));
        System.out.println(obj.longestConsecutiveSequence(root1));

    }


    public int longestConsecutiveSequence(TreeNode root) {


        if (root == null) {
            return 0;
        }

        int max[] = { Integer.MIN_VALUE };
        longestConsecutiveHelper(root, 0, root.val, max);

        return max[0];
    }

    private void longestConsecutiveHelper(TreeNode root, int cur, int target, int max[]) {


        if (root == null) {
            return;
        }

        if (root.val == target) {
            cur++;
        } else {
            cur = 1;
        }

        max[0] = Math.max(max[0], cur);
        longestConsecutiveHelper(root.left, cur, root.val + 1, max);
        longestConsecutiveHelper(root.right, cur, root.val + 1, max);

    }
}
