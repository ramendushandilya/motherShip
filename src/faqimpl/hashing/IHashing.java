package faqimpl.hashing;

/**
 * Find if there are duplicates at K distance in an array
 * Find if the two sets are disjoint or not, meaning do they have any common element
 * Given an array which has repetitions of the element in the array, group them elements by their first occurrence
 */

public interface IHashing {

    void checkDupsInDistanceK(int[] array, int k);

    void isDisjoint(int[] arrayOne, int[] arrayTwo);

    void groupMultipleByOrder(int[] array);

    void distinctElementsInSlidingWindow(int[] array, int windowSize);
}
