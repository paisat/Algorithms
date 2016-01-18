package tree;

/**
 * Created by sarvothampai on 07/10/15.
 *
 * Time Complexity : O(N)
 *
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums != null && nums.length != 0) {
            return constructTree(nums, 0, nums.length - 1);
        }

        return null;

    }

    private TreeNode constructTree(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        if (start == end) {
            return root;
        }

        root.left = constructTree(nums, start, mid - 1);
        root.right = constructTree(nums, mid + 1, end);

        return root;

    }
}
