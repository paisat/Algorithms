package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 25/12/15.
 * <p/>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p/>
 * Return a deep copy of the list.
 */
public class CopyLinkedListWithRandomPointer {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();


        RandomListNode orig = head;

        while (orig != null) {

            RandomListNode copy = new RandomListNode(orig.label);
            map.put(orig, copy);
            orig = orig.next;
        }

        orig = head;

        while (orig != null) {

            RandomListNode copy = map.get(orig);
            copy.next = map.get(orig.next);
            copy.random = map.get(orig.random);
            orig = orig.next;

        }

        return map.get(head);

    }


    /**
     * Time Complexity : O(N)
     * <p/>
     * Space complexity : O(1)
     */
    public RandomListNode copyRandomList2(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode orig = head;

        while (orig != null) {

            RandomListNode next = orig.next;

            RandomListNode copy = new RandomListNode(orig.label);
            orig.next = copy;
            copy.next = next;
            orig = next;

        }

        orig = head;

        while (orig != null) {

            if (orig.random != null) {
                orig.next.random = orig.random.next;
            }

            orig = orig.next.next;

        }

        RandomListNode fakeHead = new RandomListNode(0);
        RandomListNode p = fakeHead;

        orig = head;

        while (orig != null) {

            RandomListNode next = orig.next.next;
            p.next = orig.next;
            p = p.next;
            orig.next = next;
            orig = next;

        }


        return fakeHead.next;


    }
}
