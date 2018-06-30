package algorithms.search.impl;

import algorithms.search.SearchInterface;

import java.util.Arrays;

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

    /**
     * Interpolation search works on a uniformly distributed & sorted array
     * Position finding formula : low + ((element - a[low])/(a[high]-a[low])*(high-low)
     * This position tells the nearest location to the element possible
     * Best case time complexity : O(log log n) and worst case : O(n)
     * @param input
     * @param element
     * @return
     */
    @Override
    public int interpolationSearch(int[] input, int element) {

        int low = 0;
        int high = input.length - 1;

        while (low <= high && element >= input[low] && element <= input[high]) {

            int position = low + (int) (((double)(high-low) / (input[high]-input[low]))*(element - input[low]));
            if(input[position] == element)
                return position;
            if(input[position] < element)
                low = position++;
            if(input[position] > element)
                high = position--;
        }
        return -1;
    }

    /**
     * Use Exponential search to find an element in the array
     * Find the range by doubling index at every iteration
     * Time complexity : O(log n)
     * @param input
     * @param element
     * @return
     */
    @Override
    public int exponentialSearch(int[] input, int element) {

        //If the element is present at the first index return the index
        if(input[0] == element)
            return 0;

        //While i is less than the length and the element at index is less than the element increment index by two
        int i = 1;
        while (i < input.length && input[i] <= element)
            i *= 2;

        //Do binary search on input array from i/2 index till end of array of the index i value
        return Arrays.binarySearch(input, i/2, Math.min(i, input.length), element);
    }

    @Override
    public int sublistSearch(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int fibonacciSearch(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int ubiquitosBinarySearch(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int linearSearchRecursive(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int recursiveSubstringSearch(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int unboundedBinarySearch(int[] input, int element) {
        //Low Impact
        return 0;
    }

    @Override
    public int findMissingNumber(int[] input) {
        //Low Impact
        return 0;
    }

    @Override
    public int findElementInSortedRotatedArray(int[] input, int low, int high, int element) {

        if(low > high)
            return -1;
        int mid = (low + high) / 2;

        //If element found at the mid position return it
        if(input[mid] == element)
            return mid;

        //If the array from low to mid is sorted
        if(input[low] < input[mid]) {
            //If the element to be searched lies in the low to mid
            if(element <= input[low] && element >= input[mid])
                //Find in the first half
                return findElementInSortedRotatedArray(input, low, mid-1, element);
            //Find in the second half
            return findElementInSortedRotatedArray(input, mid+1, high, element);
        }

        //If the element to be searched lies in the second half
        if(element >= mid && element <= high) {
            //Find in the second half
            return findElementInSortedRotatedArray(input, mid+1, high, element);
        }
        //Find in the first half
        return findElementInSortedRotatedArray(input, low, mid-1, element);
    }

    @Override
    public int medianTwoSortedArrays(int[] input) {

        //Low impact
        return 0;
    }

    @Override
    public void twoElementsSumClosestToZero(int[] input) {

        int low = 0;
        int high = input.length-1;
        int sum = 0;
        int sumMin = Integer.MAX_VALUE;
        int min_l = 0;
        int min_r = 0;
        Arrays.sort(input);
        while (low < high) {

            sum = input[low] + input[high];
            if(sumMin > sum) {
                sumMin = sum;
                min_l = low;
                min_r = high;
            }

            if(sum > 0) {
                low++;
            }
            if(sum < 0) {
                high--;
            }
        }
        System.out.printf("Elements closest to zero are"+input[min_l]+"=="+input[min_r]);
    }

    @Override
    public void smallestSecondSmallest(int[] input) {

    }

    @Override
    public void maxMinArrayLeastComparison(int[] input) {

    }

    @Override
    public int kthLargestElement(int[] input) {
        return 0;
    }
}
