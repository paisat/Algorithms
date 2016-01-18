package linkedlist;

/**
 * Created by sarvothampai on 08/10/15.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class DetectWhereCycleStarts {

    public static void main(String[] args) {


        DetectWhereCycleStarts obj = new DetectWhereCycleStarts();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
//        head.next.next =new ListNode(0);
//        head.next.next.next =new ListNode(-4);
//        head.next.next.next.next = head.next;

        //head.next.next=head;

        ListNode cycle = obj.detectCycle(head);

        if (cycle != null) {
            System.out.println(cycle.val);
        }


    }

    public ListNode detectCycle(ListNode head) {


        if (head != null) {

            ListNode slow = head;
            ListNode fast = head;
            ListNode cycle = null;


            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow != null && fast != null && slow == fast) {
                    cycle = slow;
                    break;
                }

            }

            if (cycle == null) {
                return null;
            }


            ListNode ptr1 = head;


            while (true) {

                ListNode cur = cycle;
                while (cur.next != cycle && cur.next != ptr1) {
                    cur = cur.next;
                }

                if (cur.next == ptr1) {
                    return ptr1;
                }

                ptr1 = ptr1.next;

            }

        }


        return null;


    }


    public void detectAndDeleteCycle(ListNode head) {


        if (head != null) {

            ListNode slow = head;
            ListNode fast = head;
            ListNode cycle = null;


            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow != null && fast != null && slow == fast) {
                    cycle = slow;
                    break;
                }

            }

            if (cycle == null) {
                return;
            }


            slow = head;

            while (slow != fast.next) {

                slow = slow.next;
                fast = fast.next;
            }


            fast.next = null;

        }
    }


    private ListNode cycleStarts2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                // found the cycle
                break;
        }

        if (fast == null || fast.next == null)
            // in case there is no cycle
            return null;

        // let the slow pointer go from the head
        // and meet the fast pointer
        // the meeting point is our answer
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
