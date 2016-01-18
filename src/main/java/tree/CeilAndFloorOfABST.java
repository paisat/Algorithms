package tree;

/**
 * Created by sarvothampai on 24/10/15.
 */
public class CeilAndFloorOfABST {

    public static void main(String[] args) {


        CeilAndFloorOfABST obj = new CeilAndFloorOfABST();

        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(50);
        root.right = new TreeNode(105);
        root.right.left = new TreeNode(102);
        root.right.right = new TreeNode(107);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(65);

        root.left.right.left = new TreeNode(52);
        root.left.right.left.right = new TreeNode(57);

        System.out.println(obj.ceilOfABstNotEqual(root, 0));
        System.out.println(obj.floorOfABST(root, 1100));
        System.out.println(obj.floorNotEqual(root, 50));


    }

    public int ceilOfABst(TreeNode root, int input) {

        if (root == null) {
            return -1;
        }

        if (root.val == input) {
            return root.val;
        }

        if (root.val < input) {
            return ceilOfABst(root.right, input);
        }

        int ceil = ceilOfABst(root.left, input);

        return (ceil >= input) ? ceil : root.val;

    }

    public Integer floorOfABST(TreeNode root, int input) {

        if (root == null) {
            return null;
        }

        if (root.val == input) {
            return root.val;
        }

        if (root.val > input) {
            return floorOfABST(root.left, input);
        }

        Integer floor = floorOfABST(root.right, input);

        return (floor != null && floor <= input) ? floor : root.val;

    }

    public Integer ceilOfABstNotEqual(TreeNode root, int input) {

        if (root == null) {
            return null;
        }

        Integer l = ceilOfABstNotEqual(root.left, input);

        if (l != null && l > input) {
            return l;
        } else {
            if (root.val > input) {
                return root.val;
            }
        }

        return ceilOfABstNotEqual(root.right, input);


    }

    public Integer floorNotEqual(TreeNode root, int input) {

        if (root == null) {
            return null;
        }

        Integer l = floorNotEqual(root.right, input);

        if (l != null && l < input) {
            return l;
        } else {
            if (root.val < input) {
                return root.val;
            }
        }

        return floorNotEqual(root.left, input);


    }

}
