package faqimpl.stack;

import java.util.Stack;

/**
 * Design a special stack such that getting the minimum value in the stack works in a constant amount of time
 * Makes use of two stacks
 * The size of the second stack is less than size of the main stack if the input conditions are favourable
 * Space complexity is nearly O(n)
 * Improvement : When the top element in the aux stack is repeating we don't maintain that in the stack, rather reuse
 */

public class GetMinStackAppTwo extends Stack<Integer>{

    Stack<Integer> aux = new Stack<>();

    void push(int element) {
        int prevSmall = 0;
        if(isEmpty()) {
            super.push(element);
            aux.push(element);
            prevSmall = element;
        } else {
            super.push(element);
            if(aux.peek() >= element) {
                if(aux.peek() != prevSmall) {
                    aux.push(element);
                }
            }
        }
    }

    public Integer pop() {
        int poppedElement = 0;
        if(super.peek() == aux.peek()) {
            poppedElement = super.pop();
            aux.pop();
        } else {
            poppedElement = super.pop();
        }
        return poppedElement;
    }

    public void getMin() {
        if(!isEmpty()) {
            System.out.println("The minimum element is = "+ aux.peek());
        } else {
            System.out.println("Stack empty, no minimum found!!");
        }

    }
}
