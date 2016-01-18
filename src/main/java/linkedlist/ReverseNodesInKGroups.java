package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || k==0 || k==1){
            return head;
        }

        ListNode cur=head;
        ListNode prev=null,next=null;
        int i=0;

        while(i<=k && cur!=null){
            i++;
            cur=cur.next;
        }

        if(i<k){
            return head;
        }


        i=1;
        cur=head;

        while( cur!=null && i<=k){
            next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            i++;
        }

        if(next!=null){
            head.next = reverseKGroup(next,k);
        }

        return prev;
    }
}
