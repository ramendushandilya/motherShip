package datastructures.array;

/**
 * @author rams0516
 *         Date: 9/26/2017
 *         Time: 1:18 PM
 */
public class ArrayRunner {
    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();
        int[] arr = {1,4,45,6,10,-8};
        array.findPair(arr, 15);
    }
}