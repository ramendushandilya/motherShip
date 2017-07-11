package datastructures.stack;

import java.util.Stack;

/**
 * @author rams0516
 *         Date: 7/11/2017
 *         Time: 1:08 PM
 */
public class StackImpl {

    public boolean isMatchingPair(Character a, Character b) {
        if(a == '{' && b == '}') {
            return true;
        }
        if(a == '[' && b == ']') {
            return true;
        }
        if(a == '(' && b == ')') {
            return true;
        }
        return false;
    }
    /**
     *
     * @param parantheses
     */
    public void checkParantheses(String parantheses) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < parantheses.length() ; i++) {
           Character c = parantheses.charAt(i);
           if(c == '[' || c== '{' || c == '(') {
               stack.push(c);
           }
           if(c == ']' || c == '}' || c == ')') {
               if(stack.isEmpty()) {
                   System.out.println("Not Balanced");
                   break;
               }
                if(isMatchingPair(stack.peek(), c) == true ) {
                    stack.pop();
                }
           }
        }
        if(stack.size() == 0) {
           System.out.println("Balanced");
        } else {
           System.out.println("Not Balanced");
        }
     }

    /**
     * Find the next greater element in an array, if no such element print -1
     * @param array
     */
    public void nextGreaterElement(int[] array) {

    }

    /**
     * Spaghetti stack
     */


}