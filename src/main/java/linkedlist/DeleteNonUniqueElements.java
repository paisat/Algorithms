package linkedlist;

/**
 * Created by sarvothampai on 09/10/15.
 */
public class DeleteNonUniqueElements {

    public static void main(String[] args) {
        DeleteNonUniqueElements obj = new DeleteNonUniqueElements();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next=new ListNode(2);

        head=obj.deleteDuplicates(head);
        while (head!=null){
            System.out.print(head.val);
            head=head.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head != null) {

            ListNode cur = head;
            ListNode prev = null;

            while (cur != null) {

                ListNode beg = cur;
                ListNode lastDup = null;

                while (beg != null && beg.next!=null && beg.val == beg.next.val) {
                    beg = beg.next;
                    lastDup = beg;
                }

                if (lastDup != null) {
                    if (prev == null) {
                        head = lastDup.next;
                    } else {
                        prev.next = lastDup.next;
                        prev = lastDup.next;
                    }
                }

                cur = lastDup;

            }

            return head;

        }

        return null;

    }
}
