package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Problem Description:
 * <p/>
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p/>
 * Note:
 * <p/>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 */
public class BSTClosestValue2 {



    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> result = new ArrayList<Integer>();


        if (root != null && k > 0) {

            Stack<TreeNode> sucessors = new Stack<TreeNode>();
            Stack<TreeNode> predecessors = new Stack<TreeNode>();

            inorder(root, false, predecessors, target);
            inorder(root, true, sucessors, target);


            while (k-- > 0) {

                if (sucessors.isEmpty()) {
                    result.add(predecessors.pop().val);
                } else if (predecessors.isEmpty()) {
                    result.add(sucessors.pop().val);
                } else if (Math.abs(sucessors.peek().val - target) < Math.abs(predecessors.peek().val - target)) {
                    result.add(sucessors.pop().val);
                } else {
                    result.add(predecessors.pop().val);
                }

            }


        }

        return result;

    }


    private void inorder(TreeNode root, boolean reverse, Stack<TreeNode> nodes, double target) {

        if (root == null) {
            return;
        }

        inorder((reverse) ? root.right : root.left, reverse, nodes, target);

        if ((!reverse && root.val > target) || (reverse && root.val <= target)) {
            return;
        }

        nodes.push(root);

        inorder((reverse) ? root.left : root.right, reverse, nodes, target);

    }


}
