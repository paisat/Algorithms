package tree;

/**
 * Created by sarvothampai on 07/10/15.
 *
 * Complexity of the identicalTree() will be according to the tree with lesser number of nodes.
 * Let number of nodes in two trees be m and n then complexity of sameTree() is O(m) where m < n.
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
