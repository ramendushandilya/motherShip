package algorithms.search.impl;

import algorithms.search.SearchInterface;

/**
 * @author failedOptimus
 */

public class SearchImpl implements SearchInterface {


    @Override
    public int linearSearch(int[] input, int element) {

        for(int i = 0 ; i < input.length ; i++) {
            if(element == input[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time complexity : O(log n)
     * @param input
     * @param element
     * @param low
     * @param high
     * @return
     */
    @Override
    public int binarySearch(int[] input, int element, int low, int high) {

        while (low <= high) {

            int mid = (low + high)/2;
            if(input[mid] == element)
                return mid;
            if (input[mid] > element)
                return binarySearch(input, element, low, mid-1);
            if (input[mid] < element)
                return binarySearch(input, element, mid+1, high);
        }
        return -1;
    }

    /**
     * Works on sorted arrays
     * Jump in step sizes in the array and find the block where the element might be present
     * Time complexity : O(sqrt(n))
     * @param input
     * @param element
     * @return
     */
    @Override
    public int jumpSearch(int[] input, int element) {

        //If the Block size is B and Array size is A
        //Number of blocks would be A/B
        //Total comparisons would be (A/B)+(B-1), this would be minimum when B is square root of A
        //So optimal block size is square root of Array Length
        int step = (int) Math.floor(Math.sqrt(input.length));

        //Find the block in which the element may be present
        int previousBlock = 0;
        while (input[Math.min(step-1, input.length-1)] < element) {
            previousBlock = step-1;
            step += (int) Math.floor(Math.sqrt(input.length));
            //If the previous block index becomes larger than array last index, not found!
            if(previousBlock >= input.length-1)
                return -1;
        }

        //Do linear search in the block
        while (input[previousBlock] < element) {
            previousBlock++;
            //If previous block reaches the end of array or the current step, not found!
            if(previousBlock == Math.min(step, input.length-1))
                return -1;
        }

        //If the element is present at the previous block index, found!
        if(input[previousBlock] == element)
            return previousBlock;

        return -1;
    }

    @Override
    public int interpolationSearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int exponentialSearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int sublistSearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int fibonacciSearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int ubiquitosBinarySearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int linearSearchRecursive(int[] input, int element) {
        return 0;
    }

    @Override
    public int recursiveSubstringSearch(int[] input, int element) {
        return 0;
    }

    @Override
    public int unboundedBinarySearch(int[] input, int element) {
        return 0;
    }
}
