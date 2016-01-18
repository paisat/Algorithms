package linkedlist;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class DeleteDuplicates {


    public static void main(String[] args) {

        DeleteDuplicates obj = new DeleteDuplicates();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);


        ListNode newHead = obj.deleteDuplicates(head);

        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }


    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next==null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode p = fakeHead;



        while (p.next != null && p.next.next != null) {

            int dup;
            if (p.next.val == p.next.next.val) {
                dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }

            } else {
                p = p.next;
            }

        }





        return fakeHead.next;

    }
}
