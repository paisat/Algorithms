package linkedlist;

/**
 * Created by sarvothampai on 09/10/15.
 */
public class DeleteNodeInLinkedListWithoutPreviousPointer {

    public void deleteNode(ListNode node) {

        if(node.next==null){
            return;
        }

        node.val=node.next.val;
        node.next = node.next.next;



    }
}
