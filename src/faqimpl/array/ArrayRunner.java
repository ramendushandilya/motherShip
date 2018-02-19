package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] arrayy = {1,2,3,2,3,1,3};
        int[] array = {1,1,1,1,0,0,0,0,1};
        IArray impl = new ArrayImpl();
        impl.segregateOddEven(arrayy);
    }
}