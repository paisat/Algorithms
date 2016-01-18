package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 24/10/15.
 *
 *
 * Time Complexity : O(N^3)
 *
 */
public class ConstructTreeFromInorderAndLevelOrderTraversal {

    public static void main(String[] args) {

        ConstructTreeFromInorderAndLevelOrderTraversal obj = new ConstructTreeFromInorderAndLevelOrderTraversal();

        int inorder[] = { 4, 8, 10, 12, 14, 20, 22 };
        int levelOrder[] = { 20, 8, 22, 4, 12, 10, 14 };

        TreeNode root = obj.constructTree(inorder, levelOrder);

        obj.printInOrder(root);


    }

    private void printInOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }


    public TreeNode constructTree(int[] inorder, int[] levelorder) {

        if (inorder == null || inorder.length == 0 || levelorder == null || levelorder.length == 0) {
            return null;
        }


        List<Integer> inOrderList = new ArrayList<Integer>();
        List<Integer> levelOrderList = new ArrayList<Integer>();

        for (Integer i : inorder) {
            inOrderList.add(i);
        }

        for (Integer i : levelorder) {
            levelOrderList.add(i);
        }

        return construct(inOrderList, levelOrderList, 0, inOrderList.size() - 1);


    }

    private TreeNode construct(List<Integer> inorder, List<Integer> levelOrder, int start, int end) {


        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder.get(0));


        if (start == end) {
            return root;
        }

        int index = inorder.indexOf(root.val);

        List<Integer> levelOrderLeft = getLevelOrder(start, index - 1, levelOrder, inorder);
        List<Integer> levelOrderRight = getLevelOrder(index + 1, end, levelOrder, inorder);

        root.left = construct(inorder, levelOrderLeft, start, index - 1);
        root.right = construct(inorder, levelOrderRight, index + 1, end);

        return root;


    }

    private List<Integer> getLevelOrder(int start, int end, List<Integer> levelOrder, List<Integer> inOrder) {

        List<Integer> inOrderReducedList = inOrder.subList(start, end + 1);

        List<Integer> extractedLevelOrder = new ArrayList<Integer>();


        for (Integer i : levelOrder) {

            if (inOrderReducedList.contains(i)) {

                extractedLevelOrder.add(i);

            }

        }

        return extractedLevelOrder;

    }

}
