package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] array = {2,2,5,6,2,2,7};
        IArray impl = new ArrayImpl();
        impl.findMajMoore(array);
    }

}