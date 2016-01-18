package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 */
public class InsertionSortLinkedList {


    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        InsertionSortLinkedList obj = new InsertionSortLinkedList();

        head = obj.insertionSortList(head);

        ListNode cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }


    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode start = head;
        ListNode sorted = null;


        while (cur != null) {

            ListNode next = cur.next;

            if (sorted == null || cur.val <= sorted.val) {

                cur.next = sorted;
                sorted = cur;

            } else {

                start = sorted;
                while (start.next != null && start.next.val < cur.val) {
                    start = start.next;
                }

                cur.next = start.next;
                start.next = cur;

            }

            head = sorted;
            cur = next;
        }

        return head;
    }

}
