package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 24/10/15.
 *
 *
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 *
 *
 * Time Complexity : O(CatalanNumber(N))
 *
 */
public class GenerateAllUniqueBSt {

    public List<TreeNode> generateTrees(int n) {

        return generate(1, n);


    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);


            for (int j = 0; j < left.size(); j++) {

                TreeNode leftTree = left.get(j);

                for (int k = 0; k < right.size(); k++) {

                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = right.get(k);

                    list.add(root);

                }

            }

        }

        return list;

    }
}
