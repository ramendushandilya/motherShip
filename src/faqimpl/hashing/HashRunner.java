package faqimpl.hashing;

public class HashRunner {

    public static void main(String[] args) {
        int[] arr = {10,5,3,4,5,6};
        HashingImpl impl = new HashingImpl();
        impl.checkDupsInDistanceK(arr, 3);
    }

}
