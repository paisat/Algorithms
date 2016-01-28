package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 16/12/15.
 *
 * Time Complexity : O(N)
 *
 */
public class MorrisTraversalPreOrder {

    public static void main(String []args){

        MorrisTraversalPreOrder obj=new MorrisTraversalPreOrder();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        root.left.right.right = new TreeNode(6);

        System.out.println(obj.preOrderTraversal(root));
    }


    public List<Integer> preOrderTraversal(TreeNode root) {


        List<Integer> preorder = new ArrayList<Integer>();


        if (root != null) {

            TreeNode cur = root;

            while (cur != null) {

                if (cur.left == null) {
                    preorder.add(cur.val);
                    cur = cur.right;
                } else {


                    TreeNode pred = cur.left;

                    while (pred.right!=null && pred.right!=cur){
                        pred=pred.right;
                    }

                    if(pred.right==cur){
                        pred.right=null;
                        cur=cur.right;
                    }
                    else {
                        pred.right=cur;
                        preorder.add(cur.val);
                        cur=cur.left;
                    }


                }

            }


        }

        return preorder;
    }

}
