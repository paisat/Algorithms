package tree;

/**
 * Created by sarvothampai on 08/01/16.
 */
public class CheckIfTwoNodesAreCousins {

    // Java program to check if two binary tree are cousins
    class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class BinaryTree {


        // Recursive function to check if two Nodes are siblings

        boolean isSibling(Node node, Node node1, Node a, Node b) {

            // Base case
            if (node == null) {
                return false;
            }

            if ((node.left == a && node1.right == b)
                    || (node.left == b && node1.right == a)) {
                return true;
            } else {
                return (isSibling(node.left, node.right, a, b));

            }
        }

        // Recursive function to find level of Node 'ptr' in a binary tree
        int level(Node node, Node ptr, int lev) {

            // base cases
            if (node == null) {
                return 0;
            }
            if (node == ptr) {
                return lev;
            }

            // Return level if Node is present in left subtree
            int l = level(node.left, ptr, lev + 1);
            if (l != 0) {
                return l;
            }

            // Else search in right subtree
            return level(node.right, ptr, lev + 1);
        }

        // Returns 1 if a and b are cousins, otherwise 0
        int isCousin(Node node, Node a, Node b) {

            //1. The two Nodes should be on the same level in the binary tree.
            //2. The two Nodes should not be siblings (means that they should
            // not have the same parent Node).
            if ((level(node, a, 1) == level(node, b, 1)) && (isSibling(node, node, a, b))) {
                return 1;
            } else {
                return 0;
            }
        }

        //Driver program to test above functions

    }
}
