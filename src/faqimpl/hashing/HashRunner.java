package faqimpl.hashing;

public class HashRunner {

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 1, 3, 3};
        HashingImpl impl = new HashingImpl();
        impl.groupMultipleByOrder(arr);
    }

}
