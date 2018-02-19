package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] array = {3,1,4,7,5,100,10};
        IArray impl = new ArrayImpl();
        impl.maxDifferenceInArrayBigLaterTwo(array);
    }

}