package faqimpl.hashing;

public class HashRunner {

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        HashingImpl impl = new HashingImpl();
        impl.allSubArraysSumZero(arr);
    }

}
