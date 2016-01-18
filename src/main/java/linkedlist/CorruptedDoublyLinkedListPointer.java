package linkedlist;

/**
 * Created by sarvothampai on 02/01/16.
 * <p/>
 * Well, assuming that it's a doubly linked list:
 * <p/>
 * If it's the "next" pointer that got corrupted, one can begin at the tail and using the "previous" pointer, traverse the list towards the head while maintaining a reference to the last element that was traversed.
 * When you find the element that has the bad pointer, you simply need to make that element's "next" pointer point to the last element that was traversed.
 * <p/>
 * If a "previous" link is corrupted in a doubly linked list, the process can be reversed - begin at the head, traverse until the bad "previous" pointer is found and fix it using the reference to the last element that was traversed.
 */
public class CorruptedDoublyLinkedListPointer {
}
