package algorithms.searchAndSort.binarySearch;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Implements the following
 * Iterative Binary Search
 * Recursive Binary Search
 * Interpolation Search
 * Find the minimum element in a sorted and rotated array
 * Find Peak element in an array
 * Find local minimum in an array
 * Find the fixed point in an array
 * Find the frequency of an element in sorted array
 * Find the median of two sorted arrays with equal number of elements
 * Find the median of two sorted arrays with unequal number of elements
 * Find Floor and Ceiling in sorted array
 * Find floor and Ceiling in unsorted array
 * Find the maximum element in array which increases and then decreases
 * Find the element in a sorted array using Jump Search
 */
public class Runner {
    public static void main(String[] args) {
        int[] a= {0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int[] b = {};
        System.out.print(jumpSearch(a, 610));
    }

    /**
     * Binary Search Iterative, All cases Passed
     *
     * @param a
     * @param find
     * @return
     * Rev count 1
     */
    static int binarySearchIterative(int[] a, int find) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (a[mid] == find) return mid;

            if (a[mid] < find) {
                left = ++mid;
            } else {
                right = --mid;
            }
        }
        return -1;
    }

    /**
     * Binary Search Recursive, All cases passed
     *
     * @param a
     * @param find
     * @param left
     * @param right
     * @return
     */
    static int binarySearchRecursive(int[] a, int find, int left, int right) {
        if (left <= right) {
            int mid = (left + right) >> 1;

            if (a[mid] == find) return mid;

            if (a[mid] < find) {
                return binarySearchRecursive(a, find, ++mid, right);
            } else {
                return binarySearchRecursive(a, find, left, --mid);
            }
        }
        return -1;
    }

    /**
     * Does search in a uniformly distributed sorted array where bounds are known
     * Time complexity : Worst case - O(n), if uniformly distribute O(log(log n))
     * All cases passed
     * @param a
     * @param find
     * @return
     */
    static int interpolationSearch(int[] a, int find) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high && find >= a[low] && find <= a[high]) {
            int position = low + ((high - low) * (find - a[low])) / (a[high] - a[low]);

            if (a[position] == find) return position;

            if (a[position] < find) {
                low = ++position;
            } else {
                high = --position;
            }
        }
        return -1;
    }

    /**
     * Find the minimum element in a sorted and rotated array
     * Time complexity : O(log n), worst case O(n) when duplicates present in the array
     * Made use of binary search divide and conquer method
     */
    static int findMinimum(int[] a, int low, int high) {
        /**
         * Handles the case when array is not rotated at all
         */
        if(high < low) {
            return a[0];
        }

        /**
         * If there is just one element in the sub array, low and high becomes the same
         */
        if(high == low) {
            return a[low];
        }

        int mid = (low+high)/2;

        /**
         * Check if the element next to middle is less than the element at middle, in that case element next to middle
         * is the required least number
         */
        if(mid < high && a[mid+1] < a[mid]) {
            return a[mid+1];
        }

        /**
         * Check if the element previous to mid is greater than the element at middle, in that case element at middle is
         * the required least number
         */
        if(mid > low && a[mid] < a[mid-1]) {
            return a[mid];
        }


        if(a[high] > a[mid]) {
            /**
             * Search in left
             */
            return findMinimum(a, low, mid-1);
        } else {
            /**
             * Search in right
             */
            return findMinimum(a, mid+1, high);
        }
    }

    /**
     * Find the peak element in an array, http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
     * Runs in O(log n)
     * @param a
     * @param low
     * @param high
     * @return
     */
    static int findPeak(int[] a, int low, int high) {

        while(true) {
            int mid = (low + high)/2;

            /**
             * Compare middle element with neighbours, checking mid equals to zero or array length minus one is needed
             * for the corner cases where the array is either strictly increasing or decreasing
             */
            if((mid == 0 || a[mid-1] <= a[mid]) && (mid == a.length-1 || a[mid+1] <= a[mid])) {
                return mid;
            }

            /**
             * If left neighbour is greater than middle, search in left
             */
            else if(a[mid] < a[mid-1] && mid > 0) {
                high = --mid;
            } else {
                low = ++mid;
            }
        }
    }

    /**
     * Find the local Minimum in an array, works in O(log n)
     * @param a
     * @param low
     * @param high
     * @return
     */
    static int findLocalMinima(int[] a, int low, int high) {
        while(true) {
            int mid = (low + high)/2;
            /**
             * Compare middle element with neighbour and see if it's less than them
             */
            if((mid == 0 || a[mid] <= a[mid-1]) && (mid == a.length-1 || a[mid] <= a[mid+1])) {
                return mid;
            }
            /**
             * If the element is greater than the element on it's left, search in left
             */
            else if(mid > 0 && a[mid] > a[mid-1]) {
                high = --mid;
            } else {
                low = ++mid;
            }
        }
    }

    /**
     * Find the fixed point in array, point where index is equal to the value at index, runs in O(log n)
     * @param a, is in increasing order
     * @param low
     * @param high
     * @return
     */
    static int findFixedPoint(int[] a, int low, int high) {
        while(low <= high) {
            int mid = (low + high) / 2;

            /**
             * If element found at the middle index, return it
             */
            if (mid == a[mid]) {
                return mid;
            }
            /**
             * If the middle is greater than the element at the middle, search in the right side
             */
            else if (mid > a[mid]) {
                low = ++mid;
            } else{
                high = --mid;
            }
        }
        return -1;
    }

    /**
     * Find the first occurrence and the last occurrence, the difference gives the frequency count
     * @param a
     * @param element
     * @return
     */
    static int findFrequency(int[] a, int element) {
        int begin = findFirstOccurrence(a, 0, a.length-1, element);
        if (begin == -1) {
            return begin;
        }
        return findLastOccurrence(a, 0, a.length-1, element) - begin + 1;
    }

    /**
     * Find the last occurrence using binary search
     * @param a
     * @param low
     * @param high
     * @param element
     * @return
     */
    static int findLastOccurrence(int[] a, int low, int high, int element) {
        if(low <= high) {
            int mid = (low + high) >> 1;
            if(mid == a.length-1 || element < a[mid+1] && a[mid] == element) {
                return mid;
            } else if(element < a[mid]) {
                return findLastOccurrence(a, low, --mid, element);
            } else {
                return findLastOccurrence(a, ++mid, high, element);
            }
        }
        return -1;
    }

    /**
     * Find the first occurrence using binary search
     * @param a
     * @param low
     * @param high
     * @param element
     * @return
     */
    static int findFirstOccurrence(int[] a, int low, int high, int element) {
        if(low <= high) {
            int mid = (low + high) >> 1;
            if((mid == 0 || element > a[mid-1]) && a[mid] == element) {
                return mid;
            } else if(element > a[mid]) {
                return findFirstOccurrence(a, ++mid, high, element);
            } else {
                return findFirstOccurrence(a, low, --mid, element);
            }
        }
        return -1;
    }

    /**
     * Find the median element in an array
     * @param a
     * @return
     */
    static int median(int[] a) {
        if(a.length % 2 == 0) {
            return (a[a.length/2] + a[(a.length >> 1) - 1])/2;
        } else {
            return a[a.length/2];
        }
    }

    /**
     * Find the median of two sorted arrays of the same length
     * @param arrayOne
     * @param arrayTwo
     * @return
     */
    static int findMedian(int[] arrayOne, int[] arrayTwo) {
        if(arrayOne.length == 0) return -1;

        if(arrayOne.length == 1) return (arrayOne[0] + arrayTwo[0]) >> 1;

        if(arrayOne.length == 2) return (Math.max(arrayOne[0], arrayTwo[0]) + Math.min(arrayOne[1], arrayTwo[1])) >> 1;

        int medianOne = median(arrayOne);
        int medianTwo = median(arrayTwo);

        if(medianOne == medianTwo) {
            return medianOne;
        }

        /**
         * If median one is greater than median two, then the median lies either in Left sub of Array One or Right sub of
         * Array Two, else wise for the else case. Check of even numbers of elements in sub array is done since the way we
         * extract the sub array shall differ in case of whether it's odd or even
         */
        if(medianOne > medianTwo) {
            if(arrayOne.length % 2 == 0) {
                return findMedian(Arrays.copyOfRange(arrayOne, 0, (arrayOne.length>>1) + 1),
                        Arrays.copyOfRange(arrayTwo, (arrayTwo.length>>1)- 1, arrayTwo.length));
            }
            return findMedian(Arrays.copyOfRange(arrayOne, 0, (arrayOne.length>>1)+ 1),
                    Arrays.copyOfRange(arrayTwo, arrayTwo.length>>1, arrayTwo.length));
        }
        else{
            if(arrayOne.length % 2 == 0) {
                return findMedian(Arrays.copyOfRange(arrayOne, (arrayOne.length>>1)- 1,
                        arrayOne.length), Arrays.copyOfRange(arrayTwo, 0, arrayOne.length>>1 + 1));
            }
            return findMedian(Arrays.copyOfRange(arrayOne, arrayOne.length>>1, arrayOne.length),
                    Arrays.copyOfRange(arrayTwo, 0, (arrayTwo.length>>1)+ 1));
        }
    }

    /**
     * Find the median of the two sorted arrays of different lengths
     * @param arrayOne
     * @param arrayTwo
     * @return
     */
    static int findMedianUnequalSize(int[] arrayOne, int[] arrayTwo) {
        //TODO provide fix for this
        return 0;
    }

    /**
     * Find the ceiling element in the sorted array
     * @param array
     * @param element
     * @param low
     * @param high
     * @return
     */
    static int findCeil(int[] array, int element, int low, int high) {
        if(element < array[0]) return -1;
        if(element > array[array.length-1]) return -1;

        int mid = (low + high) >> 1;

        if(array[mid] == element) {
            return mid;
        } else if(array[mid] > element) {
            if(mid-1 >= low && element > array[mid-1]) {
                return mid-1;
            } else {
                return findCeil(array, element, low, mid-1);
            }
        } else {
            if(mid+1 <= high && element <= array[mid+1]) {
                return mid+1;
            } else {
                return findCeil(array, element, mid+1, high);
            }
        }
    }

    /**
     * Find floor for element in a sorted array
     * @param array
     * @param element
     * @param low
     * @param high
     * @return
     */
    static int findFloor(int[] array, int element, int low, int high) {
        if(low > high) {
            return -1;
        }

        if(element < array[0]) {
            return -1;
        }

        if(element > array[high]) {
            return array[high];
        }

        int mid = (low + high)>>1;

        if(array[mid] == element) {
            return mid;
        }

        if(mid >0 && array[mid-1] < element && element < array[mid]) {
            return mid-1;
        }

        if(element < array[mid]) {
            return findFloor(array, element, low, --mid);
        } else {
            return findFloor(array, element, ++mid, high);
        }
    }

    /**
     * Find Ceil and floor for an element in an unsorted array
     * @param array
     * @param element
     * @return
     */
    static void findFloorCeilUnsorted(int[] array, int element) {
        int floorIndex = -1;
        int ceilIndex = -1;
        int floorDistance = Integer.MAX_VALUE;
        int ceilDistance = Integer.MAX_VALUE;

        for(int i = 0 ; i < array.length ; i++) {
            //Find floor
            if(array[i] >= element && floorDistance > (array[i] - element)) {
                floorIndex= i;
                floorDistance = array[i] - element;
            }

            //Find Ceil
            if(array[i] <= element && ceilDistance > (element - array[i])) {
                ceilIndex = i;
                ceilDistance = element - array[i];
            }
        }

        if(ceilDistance == Integer.MAX_VALUE) {
            System.out.print("No ceiling value present");
        } else {
            System.out.print("The Ceil value is "+array[ceilIndex]);
        }

        if(floorDistance == Integer.MAX_VALUE) {
            System.out.print("No floor value present");
        } else {
            System.out.print("The Floor value is "+array[floorIndex]);
        }
    }

    /**
     * Find the maximum element in an array which is increasing at first and then decreases
     * @param array
     * @return
     */
    static int findMaxIncDec(int[] array, int low, int high) {
        //If there is just one element in the array
        if(low == high){
            return array[low];
        }
        //If the array contains just two elements and first is greater than the second one
        if(high == low+1 && array[low] > array[high]) {
            return array[low];
        }
        //If the array contains just two elements and the second is greater than the first one
        if(high == low +1 && array[low] < array[high]) {
            return array[high];
        }
        int mid = (low+high)>>1;
        //If the element at mid is greater than both it's neighbours
        if(array[mid] > array[mid+1] && array[mid] > array[mid-1]) {
            return array[mid];
        }
        //If the element is greater than the element next to it and less than the element previous to it, search left
        if(array[mid] > array[mid+1] && array[mid] < array[mid-1]) {
            return findMaxIncDec(array, low, --mid);
        } else {
            return findMaxIncDec(array, ++mid, high);
        }
    }

    /**
     * Jump search to find element, complexity of O(square root(n)), lies between linear search and binary search
     * @param array
     * @param element
     * @return
     */
    static int jumpSearch(int[] array, int element) {
        int jumpBlock = (int) Math.sqrt(array.length);
        int i = 0;
        while(i <= array.length-1 && array[i] <= element) {
            i += jumpBlock;
        }
        if(i > array.length-1) {
            i-= jumpBlock;
        }
        if(array[i] >element) {
            while(true) {
                if(array[i] == element) {
                    return i;
                } else {
                    i--;
                }
            }
        } else {
            while(i < array.length) {
                if(array[i] == element) {
                    return i;
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    static int exponentialSearch(int[] array, int element) {
        //TODO
        return 0;
    }

    static int unboundedBinarySearch(int[] array, int element) {
        //TODO
        return 0;
    }


}