package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 07/10/15.
 *
 *
 * Time Complexity : O(N^2)
 *
 */
public class ConstructTreeFromPostOrderAndInorder {


    public static void main(String[] args) {

        ConstructTreeFromPostOrderAndInorder obj = new ConstructTreeFromPostOrderAndInorder();

        obj.buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3});

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder != null &&
                postorder.length != 0 &&
                inorder != null && inorder.length != 0) {

            Stack<Integer> pos = new Stack<Integer>();
            List<Integer> in = new ArrayList<Integer>();

            for (int i = 0; i < postorder.length; i++) {
                pos.add(postorder[i]);
            }

            for (int i = 0; i < inorder.length; i++) {
                in.add(inorder[i]);
            }

            return build(pos, in, 0, inorder.length - 1);


        }

        return null;


    }


    private TreeNode build(Stack<Integer> postOrder, List<Integer> inorder, int inStart, int inEnd) {


        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder.pop());

        if (inStart == inEnd) {
            return node;
        }

        int index = inorder.indexOf(node.val);


        node.right = build(postOrder, inorder, index+1, inEnd);

        node.left = build(postOrder, inorder, inStart , index-1);

        return node;


    }

}
