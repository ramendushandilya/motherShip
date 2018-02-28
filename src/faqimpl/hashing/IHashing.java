package faqimpl.hashing;

/**
 * Find if there are duplicates at K distance in an array
 * Find if the two sets are disjoint or not, meaning do they have any common element
 * Given an array which has repetitions of the element in the array, group them elements by their first occurrence
 * Find the number of distinct elements in a sliding window in a given array
 * Find the elements which are present in a range but not in an array
 * Find the sub arrays whose sum is equal to zero
 * Find four numbers i, j, k, l such that i+j = k+l in a given array
 */

public interface IHashing {

    void checkDupsInDistanceK(int[] array, int k);

    void isDisjoint(int[] arrayOne, int[] arrayTwo);

    void groupMultipleByOrder(int[] array);

    void distinctElementsInSlidingWindow(int[] array, int windowSize);

    void inRangeNotInArray(int[] array, int low, int high);

    void allSubArraysSumZero(int[] array);

    void fourNumberSumEqualityPair(int[] array);
}
