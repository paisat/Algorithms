package tree;

/**
 * Created by sarvothampai on 21/12/15.
 * <p/>
 * Given a binary tree, write a function to get the maximum width of the given tree. Width of a tree is maximum of widths of all levels.
 * <p/>
 * Let us consider the below example tree.
 * <p/>
 * 1
 * /  \
 * 2    3
 * /  \     \
 * 4    5     8
 * /  \
 * 6    7
 * For the above tree,
 * width of level 1 is 1,
 * width of level 2 is 2,
 * width of level 3 is 3
 * width of level 4 is 2.
 * <p/>
 * So the maximum width of the tree is 3.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class MaxWidthOfABinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        MaxWidthOfABinaryTree obj = new MaxWidthOfABinaryTree();
        System.out.println(obj.getMaxWidthOfABinaryTree(root));

    }


    private int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    public int getMaxWidthOfABinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int height = getHeight(root);

        int nodesPerLevel[] = new int[height];

        maxWidthHelper(root, nodesPerLevel, 0);

        int max = nodesPerLevel[0];


        for (int i = 1; i < nodesPerLevel.length; i++) {

            if (nodesPerLevel[i] > max) {
                max = nodesPerLevel[i];
            }

        }
        return max;

    }


    /**
     *
     * Time Complerxity : O(N)
     *
     * */

    private void maxWidthHelper(TreeNode root, int nodesPerLevel[], int level) {

        if (root != null) {

            nodesPerLevel[level]++;
            maxWidthHelper(root.left, nodesPerLevel, level + 1);
            maxWidthHelper(root.right, nodesPerLevel, level + 1);
        }

    }


    /**
     *
     *
     * Time Complexity : O(N^2)
     *
     * */
    int getMaxWidth(TreeNode TreeNode) {
        int maxWidth = 0;
        int width;
        int h = getHeight(TreeNode);
        int i;
 
        /* Get width of each level and compare 
         the width with maximum width so far */
        for (i = 1; i <= h; i++) {
            width = getWidth(TreeNode, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    /* Get width of a given level */
    int getWidth(TreeNode TreeNode, int level) {

        if (TreeNode == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        } else if (level > 1) {
            return getWidth(TreeNode.left, level - 1)
                    + getWidth(TreeNode.right, level - 1);
        }
        return 0;

    }

}
