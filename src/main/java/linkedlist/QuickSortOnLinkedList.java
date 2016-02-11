package linkedlist;

/**
 *
 *
 * Quick sort on a linked list.
 *
 * Time Complexity : O(n log n)
 *
 * Worst Case : O(N^2)
 *
 * Worst case takes place when the array is already sorted.
 *
 * */

public class QuickSortOnLinkedList {


    public static void main(String[] args) {
        QuickSortOnLinkedList obj = new QuickSortOnLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode newHead = obj.sortLinkedList(head);

        obj.printList(newHead);

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);

        ListNode newHead1=obj.sortLinkedList(head1);

        obj.printList(newHead1);

        ListNode head2=new ListNode(4);
        head2.next=new ListNode(2);
        head2.next.next=new ListNode(7);
        head2.next.next.next=new ListNode(5);

        ListNode newHead2=obj.sortLinkedList(head2);
        obj.printList(newHead2);



    }


    private void printList(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        System.out.println();
    }


    public ListNode sortLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode p[] = new ListNode[1];
        p[0] = null;
        newHead = partition(head, p);

        ListNode pivot = p[0];

        if (newHead != pivot) {

            ListNode cur = head;

            while (cur != null && cur.next != pivot) {
                cur = cur.next;
            }

            cur.next = null;

            newHead = sortLinkedList(head);

            cur = newHead;

            while (cur != null && cur.next != null) {
                cur = cur.next;
            }

            cur.next = pivot;

        }

        pivot.next = sortLinkedList(pivot.next);

        return newHead;

    }


    private ListNode partition(ListNode head, ListNode[] pivotref) {

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        ListNode prev = fakeHead1;

        fakeHead1.next = head;
        ListNode p = head;
        ListNode p1 = fakeHead1;
        ListNode p2 = fakeHead2;

        while (p.next != null) {
            p = p.next;
        }

        int pivot = p.val;

        p = head;

        while (p != null) {

            if (p.val <= pivot) {
                p = p.next;
                prev = prev.next;
            } else {
                p2.next = p;
                prev.next = p.next;
                p = prev.next;
                p2 = p2.next;
            }

        }

        p2.next = null;
        prev.next = fakeHead2.next;

        pivotref[0] = prev;

        return fakeHead1.next;
    }


}
