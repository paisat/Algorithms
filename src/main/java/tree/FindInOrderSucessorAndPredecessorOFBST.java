package tree;

/**
 * Created by sarvothampai on 23/10/15.
 */
public class FindInOrderSucessorAndPredecessorOFBST {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(50);
        root.right = new TreeNode(105);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(65);

        root.left.right.left = new TreeNode(52);
        root.left.right.left.right = new TreeNode(57);

        FindInOrderSucessorAndPredecessorOFBST obj = new FindInOrderSucessorAndPredecessorOFBST();
        Result result = obj.findInOrderPredecessorAndSucessor(root, 65);

        if (result.getPred() != null) {
            System.out.println("Predecessor " + result.getPred().val);
        }


        if (result.getSucc() != null) {

            System.out.println("Sucessor " + result.getSucc().val);
        }


    }


    private class Result {

        private TreeNode succ;
        private TreeNode pred;


        public TreeNode getPred() {
            return pred;
        }

        public void setPred(TreeNode pred) {
            this.pred = pred;
        }

        public TreeNode getSucc() {
            return succ;
        }

        public void setSucc(TreeNode succ) {
            this.succ = succ;
        }
    }


    public Result findInOrderPredecessorAndSucessor(TreeNode root, int key) {

        if (root == null) {
            return null;
        }


        Result result = new Result();

        findInOrderSucessorAndPredecessor(root, key, result);


        return result;
    }


    private void findInOrderSucessorAndPredecessor(TreeNode root, int key, Result result) {

        if (root == null) {
            return;
        }

        if (root.val == key) {


            if (root.right != null) {

                TreeNode left = root.right;

                while (left.left != null) {
                    left = left.left;
                }

                result.setSucc(left);

            }

            if (root.left != null) {

                TreeNode right = root.left;

                while (right.right != null) {
                    right = right.right;
                }

                result.setPred(right);

            }

            return;
        }

        if (root.val > key) {

            result.setSucc(root);
            findInOrderSucessorAndPredecessor(root.left, key, result);
        } else {

            result.setPred(root);
            findInOrderSucessorAndPredecessor(root.right, key, result);

        }

    }


}


