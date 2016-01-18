package tree;


/**
 * Created by sarvothampai on 15/10/15.
 *
 * Time Complexity : O(N)
 *
 */
public class SortedListToBalancedBSt {

    public static void main(String[] args) {

        SortedListToBalancedBSt obj = new SortedListToBalancedBSt();

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);

        TreeNode root = obj.sortedListToBST(head);

        System.out.println(root.left.val);
        System.out.println(root.right);

    }

    static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}

