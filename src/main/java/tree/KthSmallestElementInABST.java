package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 14/10/15.
 */
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {

        if(root==null){
            return 0;
        }

        Stack<TreeNode> stack  =new Stack<TreeNode>();

        boolean done =false;

        TreeNode cur=root; int smallestElement=0;

        while (!done && k!=0 ){

            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else{

                if(!stack.isEmpty()){
                    TreeNode node=stack.pop();
                    k--;

                    smallestElement = node.val;

                    cur=node.right;


                }
                else{
                    done=true;

                }

            }


        }

        return smallestElement;


    }
}
