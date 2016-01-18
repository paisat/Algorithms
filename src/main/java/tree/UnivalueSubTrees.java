package tree;

/**
 * Created by sarvothampai on 17/12/15.
 * <p/>
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 * <p/>
 * Example:
 * <p/>
 * Input: root of below tree
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * Output: 4
 * There are 4 subtrees with single values.
 * <p/>
 * <p/>
 * Input: root of below tree
 * 5
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output: 5
 * There are five subtrees with single values.
 * <p/>
 *
 * Time Complexity : O(N)
 */
public class UnivalueSubTrees {


    public static void main(String[] args) {

        UnivalueSubTrees obj = new UnivalueSubTrees();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(5);

        int count[] = { 0 };
        obj.countUniValueSubtrees(root, count);

        System.out.println(count[0]);


    }


    public boolean countUniValueSubtrees(TreeNode root, int count[]) {

        if (root == null) {
            return true;
        }

        boolean left = countUniValueSubtrees(root.left, count);
        boolean right = countUniValueSubtrees(root.right, count);


        if (left == false || right == false) {
            return false;
        }

        if (root.left != null && root.val != root.left.val) {
            return false;
        }

        if (root.right != null && root.val != root.right.val) {
            return false;
        }

        count[0]++;

        return true;

    }

}
