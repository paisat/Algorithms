package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class SortLinkedList {


    public static void main(String[] args) {

        SortLinkedList obj = new SortLinkedList();

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        head = obj.sortList(head);

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }


    }

    public ListNode sortList(ListNode head) {


        ListNode merged = head;
        if (head != null && head.next != null) {

            ListNode mid = findMid(head);

            ListNode l2 = mid.next;

            mid.next = null;

            ListNode l1 = head;

            ListNode h1 = sortList(l1);

            ListNode h2 = sortList(l2);

            merged = merge(h1, h2);

            return merged;

        }

        return merged;
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;

        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return fakeHead.next;

    }

    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

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
