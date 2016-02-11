package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class DeleteAlternateNodeInALinkedList {


    public static void main(String[] args) {

        DeleteAlternateNodeInALinkedList obj = new DeleteAlternateNodeInALinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = obj.deleteAlternateNodesInALinkedList(head);

        newHead = obj.deleteAlternateNodesIteratively(head);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }


    }

    public ListNode deleteAlternateNodesInALinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteAlternateNodesInALinkedList(head.next.next);
        return head;
    }

    public ListNode deleteAlternateNodesIteratively(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return head;


    }


}
