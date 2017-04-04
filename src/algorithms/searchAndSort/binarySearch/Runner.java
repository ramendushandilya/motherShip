/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
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
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER. 
 
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
*/