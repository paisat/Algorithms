package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 21/12/15.
 * <p/>
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 * <p/>
 * For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.
 * <p/>
 * <p/>
 * 1
 * /   \
 * 2      3
 * /  \
 * 4     5
 * /
 * 7
 * <p/>
 * Time Complexity : O(N)
 *
 */
public class AncestorsOfABinaryTree {

    public static void main(String[] args) {

        AncestorsOfABinaryTree obj = new AncestorsOfABinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        System.out.println(obj.getAncestorOfBinaryTree(root, 7));


    }


    public List<Integer> getAncestorOfBinaryTree(TreeNode root, Integer val) {

        List<Integer> ancestors = new ArrayList<Integer>();
        if (root != null && val != null) {
            getAncestorsHelper(root, ancestors, val);
        }

        return ancestors;

    }

    private boolean getAncestorsHelper(TreeNode root, List<Integer> ancestors, Integer val) {

        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (getAncestorsHelper(root.left, ancestors, val) || getAncestorsHelper(root.right, ancestors, val)) {
            ancestors.add(root.val);

            return true;
        }

        return false;
    }

}
