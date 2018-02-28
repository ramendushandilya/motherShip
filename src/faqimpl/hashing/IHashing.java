package faqimpl.hashing;

/**
 * Find if there are duplicates at K distance in an array
 * Find if the two sets are disjoint or not, meaning do they have any common element
 */

public interface IHashing {

    void checkDupsInDistanceK(int[] array, int k);

    void isDisjoint(int[] arrayOne, int[] arrayTwo);

}
