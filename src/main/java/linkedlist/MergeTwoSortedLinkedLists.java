package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 * <p/>
 * <p/>
 * Time Complexity : O(M+N)
 */
public class MergeTwoSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
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

    public ListNode mergeTwoListsRec(ListNode a, ListNode b) {
        ListNode result = null;

  /* Base cases */
        if (a == null)
            return (b);
        else if (b == null)
            return (a);

  /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = mergeTwoListsRec(a.next, b);
        } else {
            result = b;
            result.next = mergeTwoListsRec(a, b.next);
        }
        return (result);
    }
}
