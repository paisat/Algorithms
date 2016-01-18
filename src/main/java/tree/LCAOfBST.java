package tree;

/**
 * Created by sarvothampai on 12/10/15.
 * <p/>
 * <p/>
 * Time complexity : O(H)
 * H is height of the tree
 */
public class LCAOfBST {


    public static void main(String[] args) {


        LCAOfBST obj = new LCAOfBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(6);

        TreeNode lca = obj.lowestCommonAncestor(root, root.left.left.left, root.left.right);

        if (lca != null) {
            System.out.println(lca.val);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root != null && p != null && q != null) {


            boolean isPPresent = findNode(root, p);
            boolean isQPresent = findNode(root, q);

            if (isPPresent && isQPresent) {

                return findLCA(root, p, q);
            }

        }

        return null;
    }

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;

        }

        if (p.val < root.val && q.val < root.val) {
            return findLCA(root.left, p, q);
        }


        if (p.val > root.val && q.val > root.val) {
            return findLCA(root.right, p, q);
        }

        return root;


    }

    private boolean findNode(TreeNode root, TreeNode q) {

        if (root == null || q == null) {
            return false;

        }


        if (root.val == q.val) {
            return true;
        }


        if (q.val < root.val) {
            return findNode(root.left, q);
        }

        return findNode(root.right, q);

    }


    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }

        }

        return root;

    }

}
