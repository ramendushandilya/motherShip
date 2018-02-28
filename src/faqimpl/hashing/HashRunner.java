package faqimpl.hashing;

public class HashRunner {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        HashingImpl impl = new HashingImpl();
        impl.distinctElementsInSlidingWindow(arr, 4);
    }

}
