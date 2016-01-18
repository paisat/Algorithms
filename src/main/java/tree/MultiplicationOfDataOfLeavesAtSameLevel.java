package tree;

import com.sun.tools.example.debug.tty.TTYResources;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sarvothampai on 29/12/15.
 *
 * Given a Binary Tree, return following value for it.
 1) For every level, compute sum of all leaves if there are leaves at this level. Otherwise ignore it.
 2) Return multiplication of all sums.

 Examples:

 Input: Root of below tree
 2
 /   \
 7     5
 \
 9
 Output: 63
 First levels doesn't have leaves. Second level
 has one leaf 7 and third level also has one
 leaf 9.  Therefore result is 7*9 = 63


 Input: Root of below tree
 2
 /   \
 7      5
 / \      \
 8   6      9
 / \    /  \
 1  11  4    10

 Output: 208
 First two levels don't have leaves. Third
 level has single leaf 8. Last level has four
 leaves 1, 11, 4 and 10. Therefore result is
 8 * (1 + 11 + 4 + 10)
 *
 *
 */
public class MultiplicationOfDataOfLeavesAtSameLevel {


    public static void main(String []args){

        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(7);
        root.right=new TreeNode(5);
        root.right.right=new TreeNode(9);

        TreeNode root1=new TreeNode(2);
        root1.left=new TreeNode(7);
        root1.right=new TreeNode(5);

        root1.left.left=new TreeNode(8);
        root1.left.right=new TreeNode(6);
        root1.left.right.left=new TreeNode(1);
        root1.left.right.right=new TreeNode(11);

        root1.right.right=new TreeNode(9);
        root1.right.right.left=new TreeNode(4);
        root1.right.right.right=new TreeNode(10);

        MultiplicationOfDataOfLeavesAtSameLevel obj=new MultiplicationOfDataOfLeavesAtSameLevel();
        System.out.println(obj.multiplicationOfDataOfLeavesAtSameLevel(root));
        System.out.println(obj.multiplicationOfDataOfLeavesAtSameLevel(root1));

    }


    public int multiplicationOfDataOfLeavesAtSameLevel(TreeNode root){


        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        int result=1;

        while (!queue.isEmpty()){

            int size=queue.size();
            int levelNodeSum=0;
            boolean leafFound=false;

            for(int i=0;i<size;i++){

                TreeNode node=queue.poll();

                if(node.left==null && node.right==null){
                    levelNodeSum+=node.val;
                    leafFound=true;
                }

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }


            }

            if(leafFound){
                result=result*levelNodeSum;
            }

        }


        return result;

    }

}
