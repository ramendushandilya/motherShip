package datastructures.stack;

/**
 * @author rams0516
 *         Date: 7/11/2017
 *         Time: 1:17 PM
 */
public class StackRunner {
    public static void main(String[] arg) {
        StackImpl stack = new StackImpl();
        stack.checkParantheses("[()]{}{[()()]()}");

    }
}