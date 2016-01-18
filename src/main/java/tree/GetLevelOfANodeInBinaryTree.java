package tree;

/**
 * Created by sarvothampai on 24/10/15.
 * <p/>
 * Time Complexity : O(N)
 */
public class GetLevelOfANodeInBinaryTree {

    public static void main(String[] args) {

        GetLevelOfANodeInBinaryTree obj = new GetLevelOfANodeInBinaryTree();


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);


        System.out.println(obj.geLevelOfANode(root, 1, 3));
        System.out.println(obj.geLevelOfANode(root, 1, 2));
        System.out.println(obj.geLevelOfANode(root, 1, 5));
        System.out.println(obj.geLevelOfANode(root, 1, 1));
        System.out.println(obj.geLevelOfANode(root, 1, 4));
        System.out.println(obj.geLevelOfANode(root, 1, 23));


    }

    public Integer geLevelOfANode(TreeNode root, Integer level, Integer node) {


        if (root == null || node == null) {
            return null;
        }

        if (root.val == node) {
            return level;
        }

        Integer l = geLevelOfANode(root.left, level + 1, node);

        if (l != null) {
            return l;

        }

        l = geLevelOfANode(root.right, level + 1, node);


        return l;

    }
}
