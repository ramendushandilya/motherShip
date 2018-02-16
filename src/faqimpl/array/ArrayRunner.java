package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,4,4,4};
        IArray impl = new ArrayImpl();
        impl.findMajLinear(array);
    }

}