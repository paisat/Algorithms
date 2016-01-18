package stacks;

import java.util.Stack;

/**
 * Created by sarvothampai on 13/12/15.
 */
public class ImplementQueueUsingStacks {


    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {

        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();


    }

    public void push(int x) {

        stack1.add(x);
    }


    public void pop() {


        if (!stack2.isEmpty()) {
            stack2.pop();
            return;
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        stack2.pop();

    }

    public int peek() {


        if(!stack2.isEmpty()){
            return stack2.peek();
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }


        if(!stack2.isEmpty()){
            return stack2.peek();
        }

        return 0;

    }


    public boolean empty() {

        return stack1.isEmpty() && stack2.isEmpty();

    }

}
