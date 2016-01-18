package tree;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * Time Complexity log(N)
 *
 */
public class BSTClosestValue {

    private float min = Float.MAX_VALUE;
    private int ans = 0;


    public Integer closestValue(TreeNode root, double target) {

        if (root == null) {
            return null;
        }

        closestValueHelper(root, target);

        return ans;


    }


    public int closestValue2(TreeNode root, double target) {
        int closestVal = root.val;
        while(root != null){
            //update closestVal if the current value is closer to target
            closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal))? root.val : closestVal;
            if(closestVal == target){   //already find the best result
                return closestVal;
            }
            root = (root.val > target)? root.left: root.right;   //binary search
        }
        return closestVal;
    }


    private void closestValueHelper(TreeNode root, double target) {


        if (root == null) {
            return;
        }

        if (Math.abs(root.val - target) < min) {
            min = (float) Math.abs(root.val - target);
            ans = root.val;
        }

        if (root.val > target) {

            closestValueHelper(root.left, target);
        } else {
            closestValueHelper(root.right, target);
        }


    }


}
