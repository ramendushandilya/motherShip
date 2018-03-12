package faqimpl.stack;

import java.util.ArrayList;
import java.util.List;

public class StackRunner {

    public static void main(String[] args) {
        UsingStack usingStack = new UsingStack();
        int[] arr = {98,23,54,12,20,7,27};

        List<Intervals> intervalsList = new ArrayList<>();
        /*intervalsList.add(new Intervals(6,8));
        intervalsList.add(new Intervals(1,9));
        intervalsList.add(new Intervals(2,4));
        intervalsList.add(new Intervals(4,7));*/

        intervalsList.add(new Intervals(1,3));
        intervalsList.add(new Intervals(2,4));
        intervalsList.add(new Intervals(5,7));
        intervalsList.add(new Intervals(6,8));
        intervalsList.add(new Intervals(40,50));

        /*intervalsList.add(new Intervals(1,3));
        intervalsList.add(new Intervals(2,6));
        intervalsList.add(new Intervals(8,10));
        intervalsList.add(new Intervals(15,18));*/

        usingStack.stockSpan(new int[]{10, 4, 5, 90, 120, 80});
    }

}

class Intervals {
    int start;
    int end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
