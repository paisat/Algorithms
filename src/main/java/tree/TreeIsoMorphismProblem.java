package tree;

/**
 * Created by sarvothampai on 08/01/16.
 * <p/>
 * <p/>
 * Time COmplexity : O(M+N)
 */
public class TreeIsoMorphismProblem {


    // An iterative java program to find height of binary tree
// A binary tree TreeNode


    static TreeNode root1, root2;

    /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null) {
            return true;
        }

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
        // Both of these subtrees have to be isomorphic, hence the &&
        // Case 2: The subtrees rooted at these nodes have been "Flipped"
        return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
                || (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
    }


}

