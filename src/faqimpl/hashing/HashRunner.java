package faqimpl.hashing;

public class HashRunner {

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        HashingImpl impl = new HashingImpl();
        impl.fourNumberSumEqualityPair(arr);
    }

}
