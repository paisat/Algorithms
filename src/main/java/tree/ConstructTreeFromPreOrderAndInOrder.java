package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sarvothampai on 07/10/15.
 * <p/>
 * Time Complexity :  O(N^2)
 */
public class ConstructTreeFromPreOrderAndInOrder {

    public static void main(String[] args) {

        ConstructTreeFromPreOrderAndInOrder obj = new ConstructTreeFromPreOrderAndInOrder();

        obj.buildTree(new int[] { 2, 1, 4, 3 }, new int[] { 1, 2, 3, 4 });

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder != null &&
                preorder.length != 0 &&
                inorder != null && inorder.length != 0) {

            Queue<Integer> pre = new ArrayDeque<Integer>();
            List<Integer> in = new ArrayList<Integer>();

            for (int i = 0; i < preorder.length; i++) {
                pre.add(preorder[i]);
            }

            for (int i = 0; i < inorder.length; i++) {
                in.add(inorder[i]);
            }

            return build(pre, in, 0, inorder.length - 1);


        }

        return null;


    }


    private TreeNode build(Queue<Integer> preorder, List<Integer> inorder, int inStart, int inEnd) {


        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder.poll());


        if (inStart == inEnd) {
            return node;
        }

        int index = inorder.lastIndexOf(node.val);


        node.left = build(preorder, inorder, inStart, index - 1);

        node.right = build(preorder, inorder, index + 1, inEnd);

        return node;


    }
}
