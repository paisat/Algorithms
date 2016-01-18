package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:

    Given 1->2->3->4->5->NULL and k = 2,

    return 4->5->1->2->3->NULL.
 *
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }


        ListNode cur = head;
        int length = 1;

        while (cur.next != null) {

            cur = cur.next;
            length++;

        }

        cur.next = head;

        k = k % length;


        if (k != 0) {
            k = length - k;
            while (k > 0) {
                cur = cur.next;
                k--;
            }
        }

        head = cur.next;
        cur.next = null;

        return head;


    }

}
