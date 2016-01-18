package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class ReverseLinkedList {

    private ListNode reverse(ListNode head,ListNode prev){

        if(head==null){
            return prev;
        }

        ListNode next =head.next;
        head.next =prev;

        return reverse(next,head);


    }

}
