package faqimpl.stack;

public class StackRunner {

    public static void main(String[] args) {
        GetMinStackAppTwo stack = new GetMinStackAppTwo();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(15);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        //stack.reveal();
        stack.getMin();
    }

}
