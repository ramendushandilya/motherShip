package algorithms.search;

import algorithms.search.impl.SearchImpl;

/**
 * @author failedOptimus
 */

public class SearchRunner {

    public static void main(String[] args) {

        SearchInterface search = new SearchImpl();
        int[] normalInput = {5,4,3,2,1,6,7,8,9};
        int[] sortedInput = {1,2,3,4,5,6,7,8,8,8};

        System.out.printf("Element found at with Linear Search="+search.linearSearch(normalInput, 3));
        System.out.printf("\nElement found at with Binary Search="+search.binarySearch(sortedInput, 9, 0, sortedInput.length-1));
        System.out.printf("\nElement found at with Jump Search="+search.jumpSearch(sortedInput, 10));
        System.out.printf("\nElement found at with Interpolation Search="+search.interpolationSearch(sortedInput, 7));
        System.out.println("\nElement found at with Exponential Search="+search.exponentialSearch(sortedInput, 9));

    }
}