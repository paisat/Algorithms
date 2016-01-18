package tree;

/**
 * Created by sarvothampai on 21/12/15.
 * <p/>
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree.
 * The diagram below shows two trees each with diameter nine,
 * the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 *
 * Time Complexity : O(N^2)
 */
public class DiameterOfBinaryTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();

        System.out.println(obj.diameter(root));

    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }


    public int diameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));

    }


}
