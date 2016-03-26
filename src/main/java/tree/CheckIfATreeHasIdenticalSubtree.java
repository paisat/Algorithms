package tree;

import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 14/03/16.
 * <p/>
 * Find if a given binary tree has duplicate sub trees or not.
 * (Two leaf nodes of a parent do not count as subtree)
 * <p/>
 * <p/>
 * //Todo Google
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class CheckIfATreeHasIdenticalSubtree {


    @Test
    public void testSucessFull() {

        CheckIfATreeHasIdenticalSubtree obj = new CheckIfATreeHasIdenticalSubtree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Assert.assertTrue(obj.hasIdenticalSubTree(root));


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);

        Assert.assertFalse(obj.hasIdenticalSubTree(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);

        Assert.assertFalse(obj.hasIdenticalSubTree(root2));

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(4);
        root3.right.left = new TreeNode(3);

        Assert.assertFalse(obj.hasIdenticalSubTree(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(3);
        root4.left.right = new TreeNode(4);
        root4.left.left.left = new TreeNode(5);
        root4.left.left.right = new TreeNode(6);
        root4.right.left = new TreeNode(5);
        root4.right.right = new TreeNode(6);

        Assert.assertTrue(obj.hasIdenticalSubTree(root4));

        TreeNode root5 = new TreeNode(1);

        Assert.assertFalse(obj.hasIdenticalSubTree(root5));

        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(3);

        Assert.assertFalse(obj.hasIdenticalSubTree(root6));

        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(2);
        root7.right = new TreeNode(3);
        root7.left.left = new TreeNode(4);
        root7.left.left.left = new TreeNode(5);
        root7.right.left = new TreeNode(2);
        root7.right.left.left = new TreeNode(4);
        root7.right.left.left.left = new TreeNode(7);

        Assert.assertTrue(obj.hasIdenticalSubTree(root7));


        TreeNode root8 = new TreeNode(1);
        root8.left = new TreeNode(2);
        root8.right = new TreeNode(3);
        root8.left.left = new TreeNode(3);
        root8.left.right = new TreeNode(4);
        root8.left.left.left = new TreeNode(5);
        root8.left.left.right = new TreeNode(6);
        root8.right.left = new TreeNode(2);
        root8.right.left.left = new TreeNode(3);
        root8.right.left.right = new TreeNode(4);
        root8.right.left.left.left = new TreeNode(5);
        root8.right.left.left.right = new TreeNode(6);

        Assert.assertTrue(obj.hasIdenticalSubTree(root8));


    }


    public boolean hasIdenticalSubTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        boolean[] hasSubtree = new boolean[1];

        HashSet<String> subTrees = new HashSet<String>();

        identicalSubTreeHelper(root, subTrees, hasSubtree);

        return hasSubtree[0];
    }


    private String identicalSubTreeHelper(TreeNode root, HashSet<String> tree, boolean hasIdenticalSubTree[]) {

        if (root == null) {
            return "null";
        }

        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        String left = identicalSubTreeHelper(root.left, tree, hasIdenticalSubTree);
        String right = identicalSubTreeHelper(root.right, tree, hasIdenticalSubTree);

        String levelLeft = (root.left != null) ? root.left.val + "" : "null";
        String levelRight = (root.right != null) ? root.right.val + "" : "null";

        String levelKey = root.val + levelLeft + levelRight;
        String key = root.val + left + right;

        if (tree.contains(levelKey) || tree.contains(key)) {
            hasIdenticalSubTree[0] = true;
        }
        tree.add(levelKey);
        tree.add(key);


        return key;

    }

}
