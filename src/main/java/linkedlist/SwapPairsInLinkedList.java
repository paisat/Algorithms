package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class SwapPairsInLinkedList {


    public static void main(String []args){

        SwapPairsInLinkedList obj=new SwapPairsInLinkedList();

        ListNode root=new ListNode(1);
        root.next=new ListNode(2);

        ListNode newRoot= obj.swapPairs(root);

        ListNode cur=newRoot;

        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;

        }

    }

    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next ==null){
            return head;
        }

        ListNode cur=head;
        ListNode next=cur.next;
        ListNode nextE=next.next;
        next.next = head;

        head.next = swapPairs(nextE);

        return next;


    }
}
