package algorithms.searchAndSort.binarySearch;

/**
 * Implements the following
 * Iterative Binary Search
 * Recursive Binary Search
 * Interpolation Search
 * Find the minimum element in a sorted and rotated array
 */
public class Runner {
    public static void main(String[] args) {
        int[] a= {2, 3, 4, 5, 6, 0, 1};
        System.out.print(findMinimum(a, 0, a.length-1));
    }

    /**
     * Binary Search Iterative, All cases Passed
     *
     * @param a
     * @param find
     * @return
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
         *
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

}