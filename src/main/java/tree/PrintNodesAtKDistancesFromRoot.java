package tree;

/**
 * Created by sarvothampai on 24/10/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class PrintNodesAtKDistancesFromRoot {


    public void printKDistance(TreeNode root, int k) {

        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.println(root.val);
        } else {

            printKDistance(root.left, k - 1);
            printKDistance(root.right, k - 1);
        }

    }

}
