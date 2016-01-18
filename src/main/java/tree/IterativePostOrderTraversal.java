package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 15/10/15.
 */
public class IterativePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> postTraversal = new ArrayList<Integer>();

        if(root!=null){

            Stack<TreeNode> stack =new Stack<TreeNode>();
            stack.push(root);

            while(!stack.isEmpty()){

                TreeNode current = stack.pop();
                postTraversal.add(current.val);

                if(current.left!=null){
                    stack.push(current.left);
                }

                if(current.right!=null){
                    stack.push(current.right);
                }

            }

            Collections.reverse(postTraversal);
        }

        return postTraversal;
    }
}
