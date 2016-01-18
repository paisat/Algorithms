package tree;

/**
 * Created by sarvothampai on 07/10/15.
 *
 * Time Complexity : O(N)
 */
public class CheckSameTree {



    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {

            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

        }

        return false;

    }
}
