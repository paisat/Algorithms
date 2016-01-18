package linkedlist;

/**
 * Created by sarvothampai on 09/10/15.
 * <p/>
 * Remove all elements from a linked list of integers that have value val.
 * <p/>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p/>
 * Credits:
 */
public class RemoveValueFromALinkedList {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }


        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head != null) {
            ListNode prev = head;
            ListNode cur = head.next;

            while (cur != null) {

                if (cur.val == val) {
                    ListNode next = cur.next;
                    prev.next = cur.next;
                    cur = next;

                } else {
                    prev = cur;
                    cur = cur.next;
                }


            }
        }

        return head;
    }
}
