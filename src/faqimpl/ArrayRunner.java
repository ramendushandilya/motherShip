package faqimpl;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] array = {1,4,3,3,5,2,6};
        IArray impl = new ArrayImpl();
        impl.findPairSum(array, 9);
    }

}