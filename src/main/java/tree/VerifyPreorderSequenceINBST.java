package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 20/11/15.
 * <p/>
 * Check if a given pre order sequence is valid
 * <p/>
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 */


/**
 *
 * PreorderSequence
 *
 * Time Complexity : O(N)
 * Space Complexity :O(N)
 *
 * */
public class VerifyPreorderSequenceINBST {

    public static void main(String[] args) {

        VerifyPreorderSequenceINBST obj = new VerifyPreorderSequenceINBST();
        obj.verifyPreorder(new int[] { 2, 3, 1 });


    }

    public boolean isPreorderSequenceValid(int[] preorder) {


        if (preorder != null && preorder.length != 0) {

            Stack<Integer> stack = new Stack<Integer>();
            int low = Integer.MIN_VALUE;

            for (Integer i : preorder) {

                if (i < low) {
                    return false;
                }

                while (!stack.isEmpty() && i > stack.peek()) {
                    low = stack.pop();
                }

                stack.push(i);

            }

            return true;

        }

        return false;
    }


    /**
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}


