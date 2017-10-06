package datastructures.array;

import java.util.Arrays;

/**
 * @author rams0516
 *         Date: 9/26/2017
 *         Time: 1:18 PM
 */
public class ArrayImpl {
    public void findPair(int[] array, int sum) {
        int flag = 0;
        Arrays.sort(array);
        int l = 0;
        int r = array.length-1;
        while(l < r) {
            if(array[l] + array[r] > sum) {
                r--;
            } else if(array[l] + array[r] < sum) {
                l++;
            } else {
                flag = 1;
                break;
            }
        }
        if(flag == 1) {
            System.out.println("Pair exists");
        } else {
            System.out.println("Pair doesn't exist");
        }
    }
}