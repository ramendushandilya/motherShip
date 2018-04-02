package faqimpl.stack;

import java.util.List;
import java.util.Stack;

/**
 * @author rams0516
 *         Date: 3/5/2018
 *         Time: 10:18 AM
 */
public class UsingStack {

    /**
     * Given an array of integers, print the next greater element in the array
     * Space complexity - O(n) Time complexity - O(n)
     * @param array
     */
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

    /**
     * Given a list range of intervals, merge them and return the list with merged intervals
     * e.g i/p - {{1,3}, {2,4}, {5,7}, {6,8}} to {{1,4}, {5,8}}
     * e.g i/p - {{6,8}, {1,9}, {2,4}, {4,7}} to {{1,9}}
     * e.g i/p [1,3],[2,6],[8,10],[15,18] to [1,6],[8,10],[15,18]
     * Time complexity O(n logn), space complexity - O(1)
     * @param intervals
     */
    public void mergeIntervals(List<Intervals> intervals) {

        //If the size of the interval list is one or less, return the same
        if(intervals.size() <= 1) {
            System.out.println(intervals.get(0).start+"-"+intervals.get(0).end);
        }

        //Sort the intervals based on the starting element of the intervals
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        //Iterate over the ranges and find the overlaps
        for(Intervals it : intervals) {
            if(it.start <= end) {
                end = Math.max(end, it.end);
            } else {
                System.out.println(start+"->"+end);
                start = it.start;
                end = it.end;
            }
        }
        System.out.println(start+"->"+end);
    }

    //Helper method to check the balancing pair
    boolean isMatchingPair(char one, char two) {
        if(one == '(' && two == ')')
            return true;
        else if(one == '{' && two == '}')
            return true;
        else if(one == '[' && two == ']')
            return true;
        else
            return false;
    }

    /**
     * Check if a given expression of parentheses is balanced or not
     * Time complexity - O(n), space complexity - O(n)
     * @param expression
     * @return
     */
    boolean isParanBalanced(char[] expression) {
        Stack<Character> stack = new Stack<>();

        //Iterate over the character array
        for(int i = 0 ; i < expression.length ; i++) {
            //If the expression character is opening one, push onto the stack
            if(expression[i] == '(' || expression[i] == '{' || expression[i] == '[') {
                stack.push(expression[i]);
            }

            //If the expression character is the closing one, check if the stack is empty, if yes then it's not balanced
            //If not empty and the popped element and expression at i don't form a pair then also not balanced
            if(expression[i] == ')' || expression[i] == '}' || expression[i] == ']') {
                if(stack.isEmpty()) {
                    return false;
                } else if(!isMatchingPair(stack.pop(), expression[i])) {
                    return false;
                }
            }
        }

        //Once we are done iterating the character elements, if the stack is empty then everything matched else not
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public void stockSpan(int[] array) {
        int[] span = new int[array.length];

        //Maintains the index of elements
        Stack<Integer> stack = new Stack<>();

        //Push the index of first element
        stack.push(0);
        span[0] = 1; //Span of first element is always one

        for(int i = 1 ; i < array.length ; i++) {
            //While either stack is not empty or price at index i is greater than equal to array at index on the top
            //element of the stack, pop stack
            while (!stack.isEmpty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }
            //If stack is empty then span at index i i+1 one the index value plus one for itself
            //If stack is non empty then span at index i is i minus the index value at top of the stack
            span[i] = stack.isEmpty() ? (i+1) : i - stack.peek();
            //Push i to the stack
            stack.push(i);
        }

        for(Integer i : span) {
            System.out.println(i);
        }
    }

}