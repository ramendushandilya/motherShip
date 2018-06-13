package datastructures.array.rotation.impl;

import datastructures.array.rotation.RotationInterface;

/**
 * @author failedOptimus
 */
public class RotationImpl implements RotationInterface {

    /**
     * Time complexity O(log n)
     * Space complexity constant
     * Works only if the elements are distinct
     * If the elements are repeating key can't be found in O(log n)
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    @Override
    public int searchElementInSortedRotatedArray(int[] array, int key, int low, int high) {

        if(low > high) return -1;
        int mid = (low + high) >> 1;
        //If the element at the mid position is key return position
        if(array[mid] == key) return mid;

        //If the array[low...mid] is sorted
        if(array[low] <= array[mid]) {
            //If the key lies in the range of first half
            //Search in the first half
            if(key >= array[low] && key <= array[mid]) {
                return searchElementInSortedRotatedArray(array, key, low, mid-1);
            }
            //Key doesn't lie in the left half
            //Search in the right half
            return searchElementInSortedRotatedArray(array, key, mid+1, high);
        }

        //If the first half is not sorted, the second half must be sorted
        //If the key is contained in the
        if(key >= array[mid] && key <= array[high]) {
            return searchElementInSortedRotatedArray(array, key, mid+1, high);
        }
        return searchElementInSortedRotatedArray(array, key, low, mid-1);
    }
}