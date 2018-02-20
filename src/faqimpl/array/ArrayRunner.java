package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:14 PM
 */
public class ArrayRunner {

    public static void main(String[] args) {
        int[] arrayy  = {1,60,-10,70,-80,85};
        int[] arr = {6,9,1,4,2,7};
        IArray impl = new ArrayImpl();
        if(impl.findTripletSumToANumber(arr, 8) == true) {
            System.out.println("Triplet with given sum exists");
        } else {
            System.out.println("Triplet with given sum does not exist");
        }
    }
}