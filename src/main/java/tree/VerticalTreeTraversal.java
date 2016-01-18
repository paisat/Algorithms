package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sarvothampai on 22/12/15.
 *
 * Time Complexity : O(N)
 *
 */
public class VerticalTreeTraversal {

    public static void main(String []args){

        VerticalTreeTraversal obj=new VerticalTreeTraversal();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);

        root.right=new TreeNode(3);
        root.right.right=new TreeNode(7);
        root.right.left=new TreeNode(6);

        Map<Integer,List<Integer>> result=obj.getVerticalTraversal(root);

        System.out.println(result.entrySet());


    }

    public Map<Integer,List<Integer>> getVerticalTraversal(TreeNode root){

        Map<Integer,List<Integer>> hdMap=new TreeMap<Integer, List<Integer>>();

        if(root!=null){


            inOrder(root,0,hdMap);
        }

        return hdMap;

    }

    private void inOrder(TreeNode root,int hd, Map<Integer,List<Integer>> hdMap){

        if(root==null){
            return;
        }

        inOrder(root.left,hd-1,hdMap);
        if(hdMap.containsKey(hd)){
            hdMap.get(hd).add(root.val);
        }
        else {
            List<Integer> list=new ArrayList<Integer>();
            list.add(root.val);
            hdMap.put(hd,list);
        }
        inOrder(root.right,hd+1,hdMap);

    }
}
