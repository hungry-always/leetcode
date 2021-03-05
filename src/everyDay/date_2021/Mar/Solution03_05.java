package everyDay.date_2021.Mar;

import java.util.Stack;

public class Solution03_05 {

}
class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        move();
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        move();
        return popStack.isEmpty();
    }

    void move() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.add(pushStack.pop());
            }
        }
    }
}
