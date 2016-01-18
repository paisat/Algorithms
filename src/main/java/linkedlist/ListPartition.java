package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 */
public class ListPartition {


    public static void main(String []args){

        ListPartition obj=new ListPartition();

        ListNode head=new ListNode(5);
        head.next=new ListNode(6);
        head.next.next=new ListNode(7);
        head.next.next.next=new ListNode(3);

        ListNode newHead=obj.partition(head,3);

        while (newHead!=null){
            System.out.print(newHead.val + " ");
            newHead=newHead.next;
        }


    }


    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while (p != null) {
            if (p.val <= x) {
                p = p.next;
                prev = prev.next;
            } else {

                p2.next = p;
                prev.next = p.next;

                p = prev.next;
                p2 = p2.next;
            }
        }

        // close the list
        p2.next = null;

        System.out.println(p2.val);

        prev.next = fakeHead2.next;

        return fakeHead1.next;
    }


}
