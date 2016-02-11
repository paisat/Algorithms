package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 * <p>
 * <p>
 * Time Complexity : O(N)
 */
public class ReverseADoublyLinkedList {


    //// TODO: 25/10/15 Complete this . Need to test 

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        ReverseADoublyLinkedList obj = new ReverseADoublyLinkedList();

        head = obj.reverse(head);

        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
    }

    public ListNode reverse(ListNode head) {

        if (head == null) {
            return head;
        }


        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {

            next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;

        }

        return prev;
    }
}
