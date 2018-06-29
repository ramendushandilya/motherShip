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

        System.out.printf("Element found at ="+search.linearSearch(normalInput, 3));
        System.out.printf("\nElement found at ="+search.binarySearch(sortedInput, 9, 0, sortedInput.length-1));
        System.out.printf("\nElement found at ="+search.jumpSearch(sortedInput, 10));
    }
}