package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:13 PM
 *         Find the pair of numbers with a given sum
 *         Find the majority element in array, linear way, moore voting algorithm
 *         Find max difference in an array, such that the bigger element comes after the smaller element
 *         Find the number occuring odd number of times in an array assuming that every other element appears even times
 *         Segregate zero and one together in an array which has only zeroes and ones
 *         Find the two pairs in an array whose sum is closet to zero
 *         Find a triplet in an array with a given sum
 *         Find the equillibrium index in an array
 *         Given an array with all zeroes in beginning and all ones towards the end, find the index where 1 starts. Size of array is not known
 *         Find the maximum number in a sliding window of size k for a given array
 *         Find the number elements smaller than the given element on the right hand side
 *         Find the subarray with a given sum
 *         Find the largest sub array in an array which contains equal number of zeroes and ones
 *         Find the product array for an array such that each element is product of all the elements of array except the present one element
 *         Improve the above function to space complexity O(1) by the use of natural logs
 *         Given an array construct a xor array such that the element equals the xor of all other elements except the current element
 *         Given an array which is nearly sorted, sort it using merge sort
 *         Given an array which has duplicate elements, find the duplicates in the array in O(n) time and constant space, elements are in the range 0 to n-1
 *         Given an array of size n+2 size every element ocurring atleast once except two which repeat, find duplicates
 *         Rotate an array by to left by d
 *         Rain water tapping problem
 *         Find the number of possible triangles in an array
 */
public interface IArray {

    void findPairSum(int[] array, int sum);

    void findMajLinear(int[] array);

    void findMajMoore(int[] array);

    void maxDifferenceInArrayBigLaterOne(int[] array);

    void maxDifferenceInArrayBigLaterTwo(int[] array);

    void findOddOccurringNumber(int[] array);

    void segregateZeroOne(int[] array);

    void segregateOddEven(int[] array);

    void findElementsSumCloseZero(int[] array);

    boolean findTripletSumToANumber(int[] array, int sum);

    void findEqIndex(int[] array);

    void findFirstOne(int[] array);

    void findMaxInSlidingWindow(int[] array, int k);

    void findSmallerOnRight(int[] array);

    void subArraySum(int[] array, int sum);

    void largestSubArrayEqualBinary(int[] array);

    void productArrayNoDiv(int[] array);

    void productBetter(int[] array);

    void xorArray(int[] array);

    void sortNearlySorted(int[] array);

    void findDuplicate(int[] array);

    void findRepeatDuplicates(int[] array);

    void rotateArrayLeft(int[] array, int d);

    void tapRainWater(int[] array);

    void numberOfTriangles(int[] array);

}