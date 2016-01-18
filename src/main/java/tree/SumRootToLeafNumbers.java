package tree;

/**
 * Created by sarvothampai on 07/10/15.
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 Time Complexity : O(n)
 *
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {

        return sumPath(root,0);

    }


    public int sumPath(TreeNode root , int val){

        if(root==null){
            return 0;
        }

        val = val*10+root.val;

        if(root.left==null && root.right==null){
            return val;
        }

        return sumPath(root.left,val) + sumPath(root.right,val);


    }

}
