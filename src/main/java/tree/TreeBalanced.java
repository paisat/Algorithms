package tree;

/**
 * Created by sarvothampai on 06/10/15.
 *
 *
 *
 * Time Complexity : O(N^2)
 *
 */
public class TreeBalanced {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;


    }


    /**
     *
     * O(N)
     *
     * */

    public boolean isBalanced2(TreeNode root) {
        boolean []res=new boolean[1];
        res[0]=true;
        maxDepth(root,res);
        return res[0];
    }

    public int maxDepth(TreeNode root,boolean[]res) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left,res);
        int r = maxDepth(root.right,res);
        if (Math.abs(l - r) > 1)
            res[0] = false;
        return 1 + Math.max(l, r);
    }

    public boolean isBalanced2(TreeNode root,int height[],int l[],int r[]) {

        if (root == null) {
            l[0]=0;
            r[0]=0;
            return true;
        }

        boolean lh = isBalanced2(root.left,height,l,r);
        boolean rh = isBalanced2(root.right, height,l,r);

        height[0]=1+Math.max(l[0],r[0]);

        if (Math.abs(l[0] - r[0]) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;


    }


    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
