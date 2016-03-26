package linkedlist;

/**
 * Created by sarvothampai on 05/03/16.
 * <p/>
 * Seggregate odd and even nodes in a linked list. Odd nodes should come first and relative order of nodes should be maintained.
 * <p/>
 * Time Complexity : O(N)
 */
public class SeggregateOddAndEven {


    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        SeggregateOddAndEven obj = new SeggregateOddAndEven();
        ListNode newHead = obj.oddEvenList(head);
        obj.printList(newHead);

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        ListNode newHead1 = obj.oddEvenList(head1);
        obj.printList(newHead1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);

        ListNode newHead2 = obj.oddEvenList(head2);
        obj.printList(newHead2);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(4);
        head3.next.next = new ListNode(6);
        ListNode newHead3 = obj.oddEvenList(head3);
        obj.printList(newHead3);

        ListNode head4 = new ListNode(2);
        obj.printList(obj.oddEvenList(head4));

        ListNode head5 = new ListNode(1);
        obj.printList(obj.oddEvenList(head5));

        ListNode head6 = new ListNode(2);
        head6.next = new ListNode(1);
        head6.next.next = new ListNode(3);

        obj.printList(obj.oddEvenList(head6));

        ListNode head7 = new ListNode(2);
        head7.next = new ListNode(4);
        head7.next.next = new ListNode(1);
        obj.printList(obj.oddEvenList(head7));

    }


    public void printList(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public ListNode oddEvenList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = null;
        ListNode endOdd = null;

        ListNode evenHead = null;
        ListNode evenEnd = null;

        ListNode cur = head;

        while (cur != null) {

            if (cur.val % 2 == 1) {

                if (oddHead == null) {
                    oddHead = cur;
                    endOdd = cur;
                } else {
                    endOdd.next = cur;
                    endOdd = endOdd.next;

                }

            } else {

                if (evenHead == null) {
                    evenHead = cur;
                    evenEnd = cur;
                } else {
                    evenEnd.next = cur;
                    evenEnd = evenHead.next;

                }

            }

            cur = cur.next;

        }

        if (evenEnd == null || oddHead == null) {
            return (evenHead == null) ? oddHead : evenHead;
        }

        endOdd.next = evenHead;
        evenEnd.next = null;

        return oddHead;

    }
}
