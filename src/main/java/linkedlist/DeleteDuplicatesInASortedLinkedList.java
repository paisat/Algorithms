package linkedlist;

/**
 * Created by sarvothampai on 06/02/16.
 * <p>
 * Delete duplicates in a sorted linked list
 * <p>
 * Time Complexity : O(N)
 */
public class DeleteDuplicatesInASortedLinkedList {

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        DeleteDuplicatesInASortedLinkedList obj = new DeleteDuplicatesInASortedLinkedList();
        head = obj.deleteDuplicates(head);
        obj.printList(head);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        head1 = obj.deleteDuplicates(head1);
        obj.printList(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);

        head2 = obj.deleteDuplicates(head2);
        obj.printList(head2);


    }


    private void printList(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public ListNode deleteDuplicates(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {

            if (prev.val == cur.val) {
                prev.next = cur.next;
                cur = prev.next;

            } else {
                prev = cur;
                cur = cur.next;
            }

        }

        return head;

    }


}
