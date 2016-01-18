package tree;

/**
 * Created by sarvothampai on 16/12/15.
 * <p/>
 * To find the postorder predecessor of node u:
 * If u has a right child, r, then pred(u) is r.
 * Otherwise If u has a left child, l, then pred(u) is l.
 * Otherwise if u has a left sibling, ls, then pred(u) is ls
 * Otherwise if u has an ancestor, v, which is a right child and has a left sibling, vls, then pred(u) is vls
 * Otherwise, pred(u) is undefined.
 * <p/>
 * Time Complexity : O(N)
 */
public class FindPostOrderPredecessor {


    public static void main(String[] args) {

        FindPostOrderPredecessor obj = new FindPostOrderPredecessor();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(6);

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        obj.postOrder(root);

        TreeNode value=new TreeNode(6);
        TreeNode pred = obj.findPostOrderPredecessor(root, value, new TreeNode(0));
        TreeNode pred2=obj.findPostOrderPredecessor(root,value,new boolean[]{false});

        if (pred != null) {
            System.out.println();
            System.out.println(pred.val);

        }

        if (pred2 != null) {
            System.out.println();
            System.out.println(pred2.val);

        }


    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    public TreeNode findPostOrderPredecessor(TreeNode root,TreeNode val,boolean found[]){

        if(root==null){
            return null;
        }

        if(found[0]){
            return root;
        }

        if(root.val==val.val){
            found[0]=true;
        }

        TreeNode pred;

        pred=findPostOrderPredecessor(root.right,val,found);

        if(pred!=null){
            return pred;
        }

        pred=findPostOrderPredecessor(root.left,val,found);

        return pred;

    }

    public TreeNode findPostOrderPredecessor(TreeNode root, TreeNode val, TreeNode parentLeft) {

        if (root == null) {
            return null;
        }

        TreeNode pred;


        pred = findPostOrderPredecessor(root.left, val, parentLeft);

        if (pred != null) {
            return pred;
        }


        pred = findPostOrderPredecessor(root.right, val, root);


        if (root.val == val.val && pred == null) {

            if (root.right != null) {
                return root.right;
            } else if (root.left != null) {
                return root.left;
            } else {

                return parentLeft.left;

            }

        }

        return pred;

    }

}
