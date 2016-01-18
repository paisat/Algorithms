package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 *
 *
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 *
 * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …

    You are required do this in-place without altering the nodes’ values.
 *
 */
public class ReArrangeAGivenLinkedListInPlace {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ReArrangeAGivenLinkedListInPlace obj = new ReArrangeAGivenLinkedListInPlace();
        obj.reorderList(head);

    }


    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode middle = findMid(head);

        ListNode next = middle.next;
        middle.next = null;

        ListNode l1 = head;
        ListNode l2 = next;

        l2 = reverse(l2);

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;

            }

            if (l2 != null) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }

        }

        head = fakeHead.next;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;

    }


    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null) {

            fast = fast.next;

            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

        }

        return slow;

    }

}
