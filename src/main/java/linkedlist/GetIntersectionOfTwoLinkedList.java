package linkedlist;

/**
 * Created by sarvothampai on 16/10/15.
 *
 * Time Complexity  O(m+n)
 *
 */
public class GetIntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if (headA == null || headB == null) {
            return null;
        }

        int a = getLength(headA);
        int b = getLength(headB);
        int difference = b - a;
        int count = 0;


        ListNode bigList, smallList;

        bigList = headB;
        smallList = headA;


        if (a > b) {
            bigList = headA;
            smallList = headB;
            difference = a - b;
        }

        while (bigList != null && count < difference) {
            bigList = bigList.next;
            count++;
        }

        while (bigList != null && smallList != null) {

            if (bigList == smallList) {
                return smallList;
            }

            bigList = bigList.next;
            smallList = smallList.next;

        }

        return null;


    }

    private int getLength(ListNode head) {

        int length = 0;

        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            length++;
        }

        return length;
    }
}
