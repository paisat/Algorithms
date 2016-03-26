package tree;

/**
 * Created by sarvothampai on 12/03/16.
 *
 * Find Minimum difference between two nodes in a BST
 *
 */
public class MinimumDifferenceBetweenTwoNodesInBST {

//    public Integer minDifference(TreeNode root){
//
//        if(root==null){
//            return null;
//        }
//
//
//
//
//    }

    private void minimumDifferenceHelper(TreeNode root,Integer []prev,Long minDifference[]){


        if(root==null){
            return;
        }
        minimumDifferenceHelper(root.left,prev,minDifference);

        if(prev[0]!=null && root.val-prev[0]<minDifference[0]){

            minDifference[0]= (long)( root.val-prev[0]);
        }

        prev[0]=root.val;
        minimumDifferenceHelper(root.right,prev,minDifference);


    }
}
