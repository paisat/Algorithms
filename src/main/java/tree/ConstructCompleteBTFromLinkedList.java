package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sarvothampai on 24/10/15.
 *
 * Given a linked list construct complete binary tree.
 *
 *
 */
public class ConstructCompleteBTFromLinkedList {

    public static void main(String[] args) {

        ConstructCompleteBTFromLinkedList obj = new ConstructCompleteBTFromLinkedList();

        ListNode head = new ListNode(10);
        head.next = new ListNode(12);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(25);
        head.next.next.next.next = new ListNode(30);
        head.next.next.next.next.next = new ListNode(36);

        obj.constructTreeFromLL(head);
    }


    public TreeNode constructTreeFromLL(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode cur = head;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        TreeNode root = new TreeNode(cur.val);

        queue.add(root);

        cur = cur.next;

        while (cur != null) {

            TreeNode parent = queue.poll();

            TreeNode left = null, right = null;

            left = new TreeNode(cur.val);
            queue.add(left);

            cur = cur.next;

            if (cur != null) {
                right = new TreeNode(cur.val);
                queue.add(right);
                cur = cur.next;
            }

            parent.left = left;
            parent.right = right;

        }

        return root;

    }
}
