package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 */
public class InsertIntoSortedCircularLinkedList {

    public static void main(String[] args) {


        InsertIntoSortedCircularLinkedList obj = new InsertIntoSortedCircularLinkedList();

        ListNode head = new ListNode(3);
        head.next = new ListNode(6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = head;


        head = obj.insertNode(head, 8);


        ListNode cur = head;

        head = obj.insertNode(head, 10);

        if (cur != null) {
            do {

                System.out.print(cur.val + " ");
                cur = cur.next;


            } while (cur != head);
        }

        System.out.println();

    }

    private ListNode insertNode(ListNode head, int key) {


        if (head == null) {

            ListNode newHead = new ListNode(key);
            newHead.next = newHead;
            return newHead;
        }

        ListNode cur = head;

        if (key <= head.val) {

            ListNode last = cur;
            while (last != null && last.next != head) {
                last = last.next;
            }

            ListNode node = new ListNode(key);
            node.next = head;
            last.next = node;

            return node;

        }

        while (cur.next != null && cur.next != head && cur.next.val <= key) {
            cur = cur.next;
        }

        ListNode node = new ListNode(key);
        node.next = cur.next;
        cur.next = node;

        return head;


    }

}
