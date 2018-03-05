package faqimpl.stack;

import java.util.Stack;

/**
 * @author rams0516
 *         Date: 3/5/2018
 *         Time: 10:18 AM
 */
public class UsingStack {

    public void nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        //Place the first element in the stack
        stack.push(array[0]);

        //Iterate the input array from next element (1st element) till last
        for(int i = 1 ; i < array.length ; i++) {
            //Moment till the stack is not empty and the top element is less than the current element in the array
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                System.out.println(stack.pop()+"->"+array[i]);
            }
            //Push the current element to the stack
            stack.push(array[i]);
        }
        //For the remaining elements in the stack there is no greater element, hence put null for them
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+"->"+"null");
        }
    }
}