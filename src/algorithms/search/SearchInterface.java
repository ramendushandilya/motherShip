package algorithms.search;

/**
 * @author failedOptimus
 */

public interface SearchInterface {

    int linearSearch(int[] input, int element);
    int binarySearch(int[] input, int element, int low, int high);
    int jumpSearch(int[] input, int element);
    int interpolationSearch(int[] input, int element);
    int exponentialSearch(int[] input, int element);
    int sublistSearch(int[] input, int element);
    int fibonacciSearch(int[] input, int element);
    int ubiquitosBinarySearch(int[] input, int element);
    int linearSearchRecursive(int[] input, int element);
    int recursiveSubstringSearch(int[] input, int element);
    int unboundedBinarySearch(int[] input, int element);

    /**
     * Linear Search v/s Binary Search
     */

    /**
     * Interpolation Search v/s Binary Search
     */

    /**
     * Binary Search Over Ternary Search
     */

    /**
     * Library implementations of Binary Searching Algorithms
     */

}