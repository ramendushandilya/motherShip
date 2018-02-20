package faqimpl.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:13 PM
 */
public class ArrayImpl implements IArray{

    //O(n) space and time complexity
    @Override
    public void findPairSum(int[] array, int sum) {
        Set<Integer> differences = new HashSet<>();
        int delta = 0;
        for(int i = 0; i < array.length; i++) {
            delta = sum - array[i];
            if(differences.contains(array[i])) {
                System.out.println("Pair => "+array[i]+" , "+delta);
            }
            differences.add(delta);
        }
    }

    //O(n) time complexity and O(1) space complexity, works only on sorted array input
    @Override
    public void findMajLinear(int[] array) {
        int middle = array.length/2;
        int flag = 0;
        for(int i = 0; i < middle+1; i++) {
            if(array[i] == array[i+middle]) {
                flag = 1;
                System.out.println("Majority element is "+array[i]);
            }
        }
        if(flag == 0) {
            System.out.println("No majority element found!");
        }
    }

    //O(n) time complexity, O(1) space complexity, works on non sorted array inputs as well
    @Override
    public void findMajMoore(int[] array) {
        //Find the candidate by voting
        int vote = 1;
        int majIndex = 0;
        int candidate = 0;
        int occurrence = 0;

        for(int i = 1; i < array.length; i++) {
            if(array[majIndex] == array[i]) {
                vote++;
            } else {
                vote--;
            }
            if(vote == 0) {
                majIndex = i;
                vote = 1;
            }
        }

        //Authenticate the claim of the majority by votes
        candidate = array[majIndex];
        for(int i = 0; i < array.length; i++) {
            if(array[i] == candidate) {
                occurrence++;
            }
        }
        if(occurrence > array.length/2) {
            System.out.println("Majority element is = "+candidate);
        } else {
            System.out.println("No majority element present in the given array");
        }
    }

    //Use of difference array in line with O(n) time complexity, O(1) space complexity
    @Override
    public void maxDifferenceInArrayBigLaterOne(int[] array) {
        int[] difference = new int[array.length-1];

        for(int i = 1; i < difference.length; i++) {
            difference[i] = array[i] - array[i-1];
        }

        int currentMax = difference[0];

        for(int i = 1 ; i < difference.length ; i++) {
            if(difference[i-1] > 0) {
                difference[i] = difference[i] + difference[i-1];
            }
            currentMax = Math.max(currentMax, difference[i]);
        }
        System.out.println("The max difference such that the larger element comes after the smaller element is "+currentMax);
    }

    //Use of indexes to calculate min so far and max difference
    @Override
    public void maxDifferenceInArrayBigLaterTwo(int[] array) {

        int minimumDSoFar = array[0];
        int maximumSoFar = array[1] - array[0];
        int runningDifference = array[1] - array[0];
        int alpha = 0;
        int beta = 0;

        for(int i = 1 ; i < array.length ; i++) {
            if(array[i] < minimumDSoFar) {
                minimumDSoFar = array[i];
                alpha = minimumDSoFar;
            } else {
                runningDifference = array[i] - minimumDSoFar;
                if(runningDifference > maximumSoFar) {
                    maximumSoFar = runningDifference;
                    beta = array[i];
                }
            }
        }
        System.out.println("The maximum difference is = "+maximumSoFar+" with elements "+alpha+" and "+beta);
    }

    //O(n) time complexity and O(1) space complexity using bitwise xor operations on elements
    @Override
    public void findOddOccurringNumber(int[] array) {
        int number = array[0];
        for(int i = 1 ; i < array.length ; i++) {
            number ^= array[i];
        }
        System.out.println("The number occuring odd number of times = "+number);
    }

    //Use of swapping elements on left and right using two references while traversing the array from both ends
    //Time complexity O(n), space complexity O(1)
    @Override
    public void segregateZeroOne(int[] array) {

        int left = 0;
        int right = array.length-1;

        while(left < right) {
            while ((array[left] == 0) && (left < right)) {
                left++;
            }

            while ((array[right] == 1) && (left < right)) {
                right--;
            }

            if(left < right) {
                array[left++] = 0;
                array[right--] = 1;
            }
        }

        System.out.println("Elements segregated, printing the end result below");
        for(int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i]+"->");
        }
    }

    //O(n) time complexity, O(1) space complexity
    //Implementing the approach for segregating 1 and 0
    @Override
    public void segregateOddEven(int[] array) {

        int left = 0;
        int right = array.length-1;

        while(left < right) {
            while(array[left] % 2 == 0 && left < right ) {
                left++;
            }

            while(array[right] % 2 ==1 & left < right) {
                right--;
            }

            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        System.out.println("Array shuffled, printing the result below...");

        for(int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i]+"->");
        }
    }

    //O(n Log n) time complexity, O(1) space complexity
    @Override
    public void findElementsSumCloseZero(int[] array) {

        int sum;
        int minSum = Integer.MAX_VALUE;
        int left = 0;
        int right = array.length-1;
        int minLeft = left;
        int minRight = right;
        Arrays.sort(array); //O(n log n) for sorting the array

        //Takes O(n) for traversing the array from both ends
        while (left < right) {
            sum = array[left] + array[right];

            if(Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minLeft = left;
                minRight = right;
            }

            if(sum < 0 ) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("The elements whose sum is closest to zero is "+ array[minLeft]+" "+array[minRight]);
    }

    //O(n2) time complexity, O(1) space complexity
    @Override
    public boolean findTripletSumToANumber(int[] array, int sum) {

        int left;
        int right;
        int sumTemp;
        //Sort the array in increasing fashion
        Arrays.sort(array);

        for(int i = 0; i < array.length-2; i++) {
            left = i+1;
            right = array.length-1;

            while (left < right) {
                sumTemp = array[i] + array[left] + array[right];
                if(sumTemp == sum) {
                    return true;
                }
                if(sumTemp < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    //O(n) time complexity and O(n) space complexity
    @Override
    public void findEqIndex(int[] array) {

        int[] leftSum = new int[array.length];
        int[] rightSum = new int[array.length];
        int lSum = array[0];
        int rSum = array[array.length-1];
        int flag = 0;

        //Construct the left sum array
        for(int i = 1 ; i < array.length ; i++) {
            leftSum[i] = lSum + array[i];
            lSum = leftSum[i];
        }

        //Construct the right sum array
        for(int i = array.length-2 ; i > 0 ; i--) {
            rightSum[i] = rSum + array[i];
            rSum = rightSum[i];
        }

        for(int i = 0 ; i < leftSum.length -1 ; i++) {
            if(leftSum[i] == rightSum[i+1]) {
                System.out.println("Equilibrium index is "+ i);
                flag = 1;
                break;
            }
        }

        if(flag == 0) {
            System.out.println("Equilibrium index not present in the array!");
        }
    }
}