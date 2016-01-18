package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Given two binary trees, check if the first tree is subtree of the second one.
 * A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
 * The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.
 * <p/>
 * For example, in the following case, tree S is a subtree of tree T.
 * <p/>
 * Tree S
 * 10
 * /    \
 * 4       6
 * \
 * 30
 * <p/>
 * <p/>
 * Tree T
 * 26
 * /   \
 * 10     3
 * /    \     \
 * 4       6      3
 * \
 * 30
 * Solution: Traverse the tree T in preorder fashion. For every visited node in the traversal, see if the subtree rooted with this node is identical to S.
 */
public class SubTree {



    public static void main(String []args){

        TreeNode t =new TreeNode(26);
        t.left=new TreeNode(10);
        t.right=new TreeNode(3);

        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(6);

        t.left.left.right=new TreeNode(30);
        t.right.right=new TreeNode(3);

        TreeNode s=new TreeNode(10);
        s.left=new TreeNode(4);
        s.right=new TreeNode(6);
        s.left.right=new TreeNode(30);

        SubTree obj=new SubTree();
        System.out.println(obj.isSubTree(t,s));
        System.out.println(obj.isSubTree2(t,s));

        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.left.left=new TreeNode(3);
        t1.right=new TreeNode(4);

        TreeNode s1=new TreeNode(1);
        s1.left=new TreeNode(2);
        s1.left.left=new TreeNode(3);
        s1.right=new TreeNode(4);
        s1.right.right=new TreeNode(5);

        System.out.println(obj.isSubTree2(t1,s1));
        System.out.println(obj.isSubTree(t1, s1));
        System.out.println(obj.isSubTree(s1,t1));



    }

    private void inOrder(TreeNode root,StringBuilder inOrder){

        if(root==null){
            inOrder.append("null,");
            return;
        }

        inOrder(root.left,inOrder);
        inOrder.append(root.val+",");
        inOrder(root.right,inOrder);
    }

    private void preOrder(TreeNode root,StringBuilder preOrder){

        if(root==null){
            preOrder.append("null,");
            return;
        }

        preOrder.append(root.val+",");
        preOrder(root.left,preOrder);
        preOrder(root.right,preOrder);
    }


    public boolean isSubTree2(TreeNode t,TreeNode s){

        if(t==null){
            return false;
        }

        if(s==null){
            return true;
        }

        StringBuilder inOrderT=new StringBuilder();
        StringBuilder inOrderS=new StringBuilder();

        inOrder(t,inOrderT);
        inOrder(s,inOrderS);

        if(!inOrderT.toString().contains(inOrderS.toString())){
            return false;
        }

        StringBuilder preOrderT=new StringBuilder();
        StringBuilder preOrderS=new StringBuilder();

        preOrder(t,preOrderT);
        preOrder(s,preOrderS);

        if(!inOrderT.toString().contains(inOrderS.toString())){
            return false;
        }

        return true;
    }

    /**
     * Time Complexity : O(mn)
     */
    public boolean isSubTree(TreeNode T, TreeNode S) {



        if (S == null) {
            return true;
        }

        if (T == null) {
            return false;
        }

        if (areTreesIdentical(T, S)) {
            return true;
        }

        return (isSubTree(T.left, S) || isSubTree(T.right, S));


    }

    private boolean areTreesIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return (root1.val == root2.val && areTreesIdentical(root1.left, root2.left) && areTreesIdentical(root1.right, root2.right));
        }

        return false;
    }

}
