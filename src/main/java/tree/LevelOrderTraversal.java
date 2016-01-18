package tree;

import arrays.Interval;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sarvothampai on 10/10/15.
 */
public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result =new ArrayList<List<Integer>>();

        if(root!=null){

            int h =getHeight(root);

            for(int i=1;i<=h;i++){

                List<Integer> levelTrav =new ArrayList<Integer>();
                levelOrderTraversal(root,i, levelTrav);
                result.add(levelTrav);
            }

        }

        return result;


    }


    /**
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * */
    public List<List<Integer>> levelOrderQueue(TreeNode root) {


        List<List<Integer>> levelOrder=new ArrayList<List<Integer>>();


        if(root!=null){

            Queue<TreeNode> queue=new LinkedList<TreeNode>();

            queue.add(root);

            while (!queue.isEmpty()){

                int size=queue.size();
                List<Integer> levelNodes=new ArrayList<Integer>();
                for(int i=0;i<size;i++){

                    TreeNode node=queue.poll();
                    levelNodes.add(node.val);


                    if(node.left!=null){
                        queue.add(node.left);
                    }

                    if(node.right!=null){
                        queue.add(node.right);
                    }

                }

                levelOrder.add(levelNodes);


            }


        }


        return levelOrder;



    }

    /**
     *
     * Time COmplexity : O(N^2)
     *
     * */
    private void levelOrderTraversal(TreeNode root , int level , List<Integer> levelTrav){
        if(level==0 || root==null){
            return;
        }
        else if(level==1){

            levelTrav.add(root.val);

        }
        else{
            levelOrderTraversal(root.left, level-1,levelTrav);
            levelOrderTraversal(root.right, level-1,levelTrav);

        }

    }



    int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1+Math.max( getHeight(root.left) , getHeight(root.right) );

    }

}
