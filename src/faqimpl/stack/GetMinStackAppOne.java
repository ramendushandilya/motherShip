package faqimpl.stack;

import java.util.Stack;

/**
 * Design a special Stack such that finding the minimum element operation in the stack happens in constant time
 * This approach uses two stacks
 * Uses extra space equal to the size of the main stack
 * Space complexity is O(n)
 */
public class GetMinStackAppOne extends Stack<Integer>{

    Stack<Integer> aux = new Stack<>();

    void push(int element) {
        if(isEmpty() == true) {
            super.push(element);
            aux.push(element);
        } else {
            super.push(element);
            if(element <= aux.peek()) {
                aux.push(element);
            } else {
                aux.push(aux.peek());
            }
        }
    }

    public Integer pop() {
        int removed = super.pop();
        aux.pop();
        return removed;
    }

    void getMin() {
        if(!isEmpty()) {
            System.out.println("The minimum element in the satck is = "+aux.peek());
        } else {
            System.out.println("Array is empty no minimum present");
        }

    }

}
