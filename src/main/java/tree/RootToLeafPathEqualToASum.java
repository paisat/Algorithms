package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 06/10/15.
 *
 * Time Complexity : O(N * j)
 *
 * j is max path length
 *
 */
public class RootToLeafPathEqualToASum {


    public static void main(String[] args) {


        RootToLeafPathEqualToASum obj = new RootToLeafPathEqualToASum();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.left.left.right = new TreeNode(-1);

        root.right.left = new TreeNode(-2);


        System.out.println(obj.pathSum(root, 2));


    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> path = new ArrayList<List<Integer>>();
        try {


            List<Integer> subPath = new ArrayList<Integer>();

            if (root != null) {
                rootToLeafPath(root, sum, subPath, 0, path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;

    }

    private void rootToLeafPath(TreeNode root, int sum, List<Integer> subPath, int pathLen, List<List<Integer>> path) {

        if (root == null) {
            return;
        }

        int subSum = sum - root.val;

        subPath.add(pathLen, root.val);


        pathLen++;

        if (subSum == 0 && root.left == null && root.right == null) {

            List<Integer> sub = new ArrayList<Integer>();
            for (int i = 0; i < pathLen; i++) {
                sub.add(subPath.get(i));
            }
            path.add(sub);

        } else {

            rootToLeafPath(root.left, subSum, subPath, pathLen, path);
            rootToLeafPath(root.right, subSum, subPath, pathLen, path);
        }


    }
}
