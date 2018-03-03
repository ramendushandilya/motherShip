package faqimpl.stack;

import java.util.Stack;

/**
 * Design a stack such that the finding of the minimum element takes place in cosntant time
 * This implementation shall be making the space complexity as constant as well
 * Shall make use of difference of the elements
 */

public class GetMinStackBest extends Stack<Integer>{

    Stack<Integer> stack = new Stack<>();
    int currentMinimum = 0;

    void push(int element) {

        if(isEmpty()) {
            super.push(element);
            currentMinimum = element;
        } else {
            if(element > currentMinimum) {
                super.push(element);
            } else {
                super.push(element-currentMinimum);
                currentMinimum = element;
            }
        }
    }

    public Integer pop() {
        if(currentMinimum > super.peek()) {
            int element = super.pop();
            currentMinimum = currentMinimum - element;
        } else {
            super.pop();
        }
        return  0;
    }

    void getMin() {

        if(!isEmpty()) {
            System.out.println("The minimum in the stack is "+currentMinimum);
        } else {
            System.out.println("The stack is empty, there is no minimum");
        }

    }

    void reveal() {
        for(int i = 0 ; i < stack.capacity() ; i++) {
            System.out.println(stack.elementAt(i));
        }
    }

}
