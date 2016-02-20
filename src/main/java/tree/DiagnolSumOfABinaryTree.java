package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by sarvothampai on 14/02/16.
 */
public class DiagnolSumOfABinaryTree {

    public static void main(String[] args) {


        DiagnolSumOfABinaryTree obj = new DiagnolSumOfABinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(11);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(12);
        root.right.right = new TreeNode(5);
        root.right.left.right = new TreeNode(7);

        System.out.println(obj.diagonalSumOfBinaryTree(root));


    }


    public Map<Integer, Integer> diagonalSumOfBinaryTree(TreeNode root) {


        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        if (root != null) {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Queue<Integer> vdQueue = new LinkedList<Integer>();


            queue.add(root);
            vdQueue.add(0);

            while (!queue.isEmpty()) {

                TreeNode cur = queue.poll();
                int vd = vdQueue.poll();

                while (cur != null) {

                    int prevSum = (result.get(vd) == null) ? 0 : result.get(vd);
                    result.put(vd, prevSum + cur.val);

                    if (cur.left != null) {
                        queue.add(cur.left);
                        vdQueue.add(vd + 1);
                    }

                    cur = cur.right;
                }

            }

        }

        return result;


    }

}
