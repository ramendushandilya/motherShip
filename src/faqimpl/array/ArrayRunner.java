package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] arrayy = {1, 60, -10, 70, -80, 85};
        int[] arr = {1,2,3,4,5,1,2};
        IArray impl = new ArrayImpl();
        impl.findRepeatDuplicates(arr);
    }
}