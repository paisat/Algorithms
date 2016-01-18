package linkedlist;

/**
 * Created by sarvothampai on 16/10/15.
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int i = 1;

        while (fast != null && i <= n) {
            fast = fast.next;
            i++;
        }


        while (fast != null && slow != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;

        }

        if (slow != null && slow == head) {
            head = head.next;
        } else if (slow != null) {

            prev.next = slow.next;
        }

        return head;

    }
}
