package tree;

/**
 * Created by sarvothampai on 12/10/15.
 * <p/>
 * O(n) complexity.
 * <p/>
 * Node *findLCA(Node *root, int n1, int n2)
 * {
 * // Initialize n1 and n2 as not visited
 * bool v1 = false, v2 = false;
 * <p/>
 * // Find lca of n1 and n2 using the technique discussed above
 * Node *lca = findLCAUtil(root, n1, n2, v1, v2);
 * <p/>
 * // Return LCA only if both n1 and n2 are present in tree
 * if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
 * return lca;
 * <p/>
 * // Else return NULL
 * return NULL;
 * }
 *
 * int getHeight(Node *p) {
    int height = 0;
    while (p) {
    height++;
    p = p->parent;
    }
    return height;
 }

 // As root->parent is NULL, we don't need to pass root in.
 Node *LCA(Node *p, Node *q) {
    int h1 = getHeight(p);
    int h2 = getHeight(q);
    // swap both nodes in case p is deeper than q.
    if (h1 > h2) {
        swap(h1, h2);
        swap(p, q);
    }
    // invariant: h1 <= h2.

    int dh = h2 - h1;
    for (int h = 0; h < dh; h++)
        q = q->parent;

    while (p && q) {
        if (p == q) return p;
        p = p->parent;
        q = q->parent;
    }
 return NULL;  // p and q are not in the same tree
 }
 *
 *
 */
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {


        LowestCommonAncestorOfBinaryTree obj = new LowestCommonAncestorOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        TreeNode lca = obj.lowestCommonAncestor(root, root.left.left, root.right.left);

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

        if (root == p || root == q) {
            return root;
        }

        TreeNode l = findLCA(root.left, p, q);
        TreeNode r = findLCA(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return (l != null) ? l : r;

    }

    private boolean findNode(TreeNode root, TreeNode p) {

        if (root == null || p == null) {
            return false;
        }


        if (root.val == p.val || findNode(root.left, p) || findNode(root.right, p)) {
            return true;
        }

        return false;

    }

}
