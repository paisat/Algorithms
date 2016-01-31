package tree;

/**
 * Created by sarvothampai on 30/01/16.
 * <p>
 * Find the distance between two keys in a binary tree, no parent pointers are given.
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
 * <p>
 * Time Complexity : O(N)
 *
 * Distance formula = Level(node a)+level (node b)- 2*level(lca of node a and node b)
 *
 */
public class DistanceBetweenTwoKeysOfABinaryTree {


    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);

        root.left=node2;
        root.right=node3;
        root.left.left=node4;
        root.left.right=node5;

        root.right.right=node7;
        root.right.left=node6;
        root.right.left.right=node8;

        DistanceBetweenTwoKeysOfABinaryTree obj=new DistanceBetweenTwoKeysOfABinaryTree();
        System.out.println(obj.getDistance(root,node4,node5));
        System.out.println(obj.getDistance(root,node4,node6));
        System.out.println(obj.getDistance(root,node3,node4));
        System.out.println(obj.getDistance(root,node2,node4));
        System.out.println(obj.getDistance(root,node8,node5));

    }


    public int getDistance(TreeNode root, TreeNode a, TreeNode b) {


        int distance = 0;
        if (root != null && a != null && b != null) {

            TreeNode lca = LCA(root, a, b);
            distance = getLevelOfAnode(root, a, 0) + getLevelOfAnode(root, b, 0) - 2 * getLevelOfAnode(root, lca, 0);

        }

        return distance;
    }

    private Integer getLevelOfAnode(TreeNode root, TreeNode node, int level) {

        if (root == null) {
            return null;
        }

        if (root == node) {
            return level;
        }

        Integer lLevel = getLevelOfAnode(root.left, node, level + 1);

        if (lLevel != null) {
            return lLevel;
        }

        return getLevelOfAnode(root.right, node, level + 1);

    }

    private TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        TreeNode l = LCA(root.left, a, b);
        TreeNode r = LCA(root.right, a, b);

        if (l != null && r != null) {
            return root;
        }

        return (l == null) ? r : l;

    }
}
