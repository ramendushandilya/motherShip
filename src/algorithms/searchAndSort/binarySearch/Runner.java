package algorithms.searchAndSort.binarySearch;

/**
 * @author rams0516
 *         Date: 4/4/2017
 *         Time: 3:17 PM
 */
public class Runner {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 8, 10, 12};
        int[] uniformlySortedArray = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};

    }

    /**
     * Binary Search Iterative, All cases Passed
     *
     * @param a
     * @param find
     * @return
     */
    static int binItr(int[] a, int find) {
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
    static int binRec(int[] a, int find, int left, int right) {
        if (left <= right) {
            int mid = (left + right) >> 1;

            if (a[mid] == find) return mid;

            if (a[mid] < find) {
                return binRec(a, find, ++mid, right);
            } else {
                return binRec(a, find, left, --mid);
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
}