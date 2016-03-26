package arrays;

import java.util.Iterator;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p/>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * <p/>
 * Call next() gets you 1, the first element in the list.
 * <p/>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * <p/>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * <p/>
 * Hint:
 * <p/>
 * Think of "looking ahead". You want to cache the next element.
 * Is one variable sufficient? Why or why not?
 * Test your design with call order of peek() before next() vs next() before peek().
 * For a clean implementation, check out Google's guava library source code.
 * <p/>
 * <p/>
 * <p/>
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 *
 * //ToDO Google
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> itr;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

        itr = iterator;
        next = null;
        if (itr.hasNext()) {
            next = itr.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    public Integer next() {

        Integer result = next;

        next = null;
        if (itr.hasNext()) {
            next = itr.next();
        }

        return result;
    }

    public void remove() {

    }


    public boolean hasNext() {
        return (next != null);
    }
}
