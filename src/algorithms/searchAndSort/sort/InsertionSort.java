package algorithms.searchAndSort.sort;

/**
 * @author rams0516
 *         Date: 4/17/2017
 *         Time: 2:55 PM
 */
public class InsertionSort {
    public static void main(String[] arg) {
        int[] array = {3 ,4, 1, 3, 2, 5, 6};
        printArray(sort(array));
    }

    static int[] sort(int[] array) {
        for(int i = 1; i < array.length ; i++) {
            int j = i - 1;
            int key = array[i];

            while(j >= 0 && key <= array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }

    static void printArray(int[] array) {
        for(int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i]+", ");
        }
    }
}