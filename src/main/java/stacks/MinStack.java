package stacks;

import java.util.Stack;

/**
 * Created by sarvothampai on 17/12/15.
 * <p/>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

    }

    public void push(int x) {
        stack1.add(x);

        if (stack2.isEmpty() || x <= getMin()) {
            stack2.add(x);
        }

    }

    public void pop() {
        if (stack1.peek() == getMin()) {
            stack2.pop();
        }

        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
