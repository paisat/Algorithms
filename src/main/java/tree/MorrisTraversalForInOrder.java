package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 16/12/15.
 */
public class MorrisTraversalForInOrder {

    public static void main(String []args){

        MorrisTraversalForInOrder obj=new MorrisTraversalForInOrder();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);


        System.out.println(obj.inOrder(root));


    }

    public List<Integer> inOrder(TreeNode root) {


        List<Integer> inorder = new ArrayList<Integer>();


        if (root != null) {

            TreeNode cur = root;

            while (cur != null) {

                if (cur.left == null) {

                    inorder.add(cur.val);
                    cur = cur.right;
                } else {

                    TreeNode pred = cur.left;

                    while (pred.right != null && pred.right != cur) {
                        pred = pred.right;
                    }

                    if (pred.right == null) {
                        pred.right = cur;
                        cur = cur.left;
                    } else {

                        pred.right = null;
                        inorder.add(cur.val);
                        cur = cur.right;

                    }

                }

            }

        }

        return inorder;

    }

}
