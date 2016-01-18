package tree;

/**
 * Created by sarvothampai on 06/01/16.
 */
public class AVLTree {

    private TreeNode leftRotate(TreeNode root) {
        TreeNode newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    private TreeNode rightRotate(TreeNode root) {
        TreeNode newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    private int setHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.height;
        }
    }

    private int setSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.size : 0), (root.right != null ? root.right.size : 0));
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val <= val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        int balance = balance(root.left, root.right);
        if (balance > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (balance < -1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        } else {
            root.height = setHeight(root);
            root.size = setSize(root);
        }
        return root;
    }

    private int balance(TreeNode rootLeft, TreeNode rootRight) {
        return height(rootLeft) - height(rootRight);
    }

    public static void main(String args[]) {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);


    }
}
