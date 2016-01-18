package linkedlist;

/**
 * Created by sarvothampai on 01/01/16.
 * <p/>
 * Time Complexity : O(M+N)
 */
public class IntersectionOfTwoLinkedList {


    public ListNode sortedInteresect(ListNode l1, ListNode l2) {


        if (l1 == null || l2 == null) {
            return null;
        }

        if (l1.val < l2.val) {
            return sortedInteresect(l1.next, l2);
        }

        if (l2.val > l1.val) {
            return sortedInteresect(l1, l2.next);
        }

        ListNode node = new ListNode(l1.val);

        node.next = sortedInteresect(l1.next, l2.next);

        return node;

    }

}
