package arrays;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvothampai on 16/01/16.
 */
public class DeepIterator implements Iterator<Integer> {

    private Stack<Iterator<Data>> stack = new Stack<Iterator<Data>>();
    private Data top = null;

    public DeepIterator(List<Data> input) {
        stack.push(input.iterator());
    }


    public boolean hasNext() {
        if (this.top != null) {
            return true;
        }

        while (!stack.isEmpty()) {
            Iterator<Data> it = stack.peek();

            if (it.hasNext()) {
                Data curr = it.next();
                if (!curr.isCollection()) {
                    top = (Data) curr.getElement();
                    return true;
                } else {
                    stack.push(curr.getCollection().iterator());
                }
            } else {
                stack.pop();
            }
        }

        return false;
    }


    public Integer next() {
        if (top != null) {
            Integer result = (Integer) top.getElement();
            top = null;
            return result;
        } else {
            return null;
        }
    }

    public void remove() {

    }
}
