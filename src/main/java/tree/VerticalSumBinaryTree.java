package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines.
 * <p/>
 * Examples:
 * <p/>
 * 1
 * /   \
 * 2      3
 * / \    / \
 * 4   5  6   7
 * The tree has 5 vertical lines
 * <p/>
 * Vertical-Line-1 has only one node 4 => vertical sum is 4
 * Vertical-Line-2: has only one node 2=> vertical sum is 2
 * Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
 * Vertical-Line-4: has only one node 3 => vertical sum is 3
 * Vertical-Line-5: has only one node 7 => vertical sum is 7
 *
 * Time Complexity : O(N)
 */

public class VerticalSumBinaryTree {


    public static void main(String[] args) {

        VerticalSumBinaryTree obj = new VerticalSumBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        Map<Integer, Integer> result = obj.getVerticalSum(root);

        System.out.println(result.entrySet());


    }

    public Map<Integer, Integer> getVerticalSum(TreeNode root) {

        Map<Integer, Integer> hdMap = new HashMap<Integer, Integer>();

        if (root != null) {


            inOrder(root, 0, hdMap);
        }

        return hdMap;

    }

    private void inOrder(TreeNode root, int hd, Map<Integer, Integer> hdMap) {

        if (root == null) {
            return;
        }

        inOrder(root.left, hd - 1, hdMap);
        int prevSum = (hdMap.get(hd) == null) ? 0 : hdMap.get(hd);
        hdMap.put(hd, prevSum + root.val);
        inOrder(root.right, hd + 1, hdMap);

    }

}
