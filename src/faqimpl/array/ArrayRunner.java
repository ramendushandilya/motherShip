package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] arrayy = {1, 60, -10, 70, -80, 85};
        int[] arr = {2,1,5,9};
        IArray impl = new ArrayImpl();
        impl.xorArray(arr);
    }
}