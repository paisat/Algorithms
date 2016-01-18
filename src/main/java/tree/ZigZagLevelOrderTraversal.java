package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 10/10/15.
 *
 *
 * Time Compelxity : O(N)
 * void printSpiral(struct node *root)
 {
    if (root == NULL)  return;   // NULL check

    // Create two stacks to store alternate levels
    stack<struct node*> s1;  // For levels to be printed from right to left
    stack<struct node*> s2;  // For levels to be printed from left to right

    // Push first level to first stack 's1'
    s1.push(root);

    // Keep ptinting while any of the stacks has some nodes
    while (!s1.empty() || !s2.empty())
    {
        // Print nodes of current level from s1 and push nodes of
        // next level to s2
        while (!s1.empty())
        {
            struct node *temp = s1.top();
            s1.pop();
            cout << temp->data << " ";

            // Note that is right is pushed before left
            if (temp->right)
                s2.push(temp->right);
            if (temp->left)
                s2.push(temp->left);
        }

        // Print nodes of current level from s2 and push nodes of
        // next level to s1
        while (!s2.empty())
        {
            struct node *temp = s2.top();
            s2.pop();
            cout << temp->data << " ";

            // Note that is left is pushed before right
            if (temp->left)
            s1.push(temp->left);
            if (temp->right);
            s1.push(temp->right);
        }
    }
 }
 *
 */
public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root != null) {

            int h = getHeight(root);

            boolean turn = true;

            for (int i = 1; i <= h; i++) {

                List<Integer> levelTrav = new ArrayList<Integer>();
                levelOrderTraversal(root, i, levelTrav, turn);
                result.add(levelTrav);
                turn = !turn;
            }

        }

        return result;


    }

    private void levelOrderTraversal(TreeNode root, int level, List<Integer> levelTrav, boolean turn) {
        if (level == 0 || root == null) {
            return;
        } else if (level == 1) {

            levelTrav.add(root.val);

        } else {

            if (turn) {
                levelOrderTraversal(root.left, level - 1, levelTrav, turn);
                levelOrderTraversal(root.right, level - 1, levelTrav, turn);
            } else {
                levelOrderTraversal(root.right, level - 1, levelTrav, turn);
                levelOrderTraversal(root.left, level - 1, levelTrav, turn);
            }

        }

    }


    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

}
