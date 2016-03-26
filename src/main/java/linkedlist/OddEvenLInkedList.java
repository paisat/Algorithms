package linkedlist;

/**
 * Created by sarvothampai on 06/03/16.
 */
public class OddEvenLInkedList {

    public static void main(String []args){


        OddEvenLInkedList obj=new OddEvenLInkedList();

        ListNode head=new ListNode(1);
        head.next=new ListNode(1);


        ListNode newHead=obj.oddEvenList(head);



    }

    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }


        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;

        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;

            odd=odd.next;
            even=even.next;

        }

        odd.next=evenHead;

        return head;


    }
}
