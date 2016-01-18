package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 07/10/15.
 *
 *
 * Time Cpmplexity : O(N)
 *
 */
public class RootToLeafPath {

    public static void main(String[] args) {


        RootToLeafPath obj = new RootToLeafPath();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.left.left.right = new TreeNode(-1);

        root.right.left = new TreeNode(-2);


        System.out.println(obj.binaryTreePaths(root));


    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<String>();

        if (root != null) {

            int path[] = new int[10000];
            printPathsRecur(root, path, 0, result);

        }

        return result;

    }


    void printPathsRecur(TreeNode node, int path[], int pathLen, List<String> result) {
        if (node == null)
            return;

      /* append this node to the path array */
        path[pathLen] = node.val;
        pathLen++;

      /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) {
            String pa = "";
            for (int i = 0; i < pathLen; i++) {
                if (i != pathLen - 1) {
                    pa = pa + path[i] + "->";
                } else {
                    pa = pa + path[i];
                }
            }

            result.add(pa);
        } else {
        /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen, result);
            printPathsRecur(node.right, path, pathLen, result);
        }
    }
}
