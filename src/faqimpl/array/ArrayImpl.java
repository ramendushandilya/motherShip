package faqimpl.array;

import sun.print.PSPrinterJob;

import java.util.*;

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

    @Override
    public void findFirstOne(int[] array) {

        /**
         * Increment the array index in multiples of x, when the first one is met, apply binary search in that bound to
         * find the first occurrence of one. Since, the size of the input is unknown nothing can be said in terms of
         * input size about the time complexity of the algorithm.
         */

    }

    //O(n) time complexity O(n) space complexity. Makes use of dynamic programming
    @Override
    public void findMaxInSlidingWindow(int[] array, int k) {

        //Number of the sliding windows possible
        int windowNumber = array.length - k + 1;
        int[] ltr = new int[array.length];
        int[] rtl = new int[array.length];
        int[] slidingWindowMaxValues = new int[windowNumber];

        //Construct the left to right array in chunks of window size
        for(int i = 0 ; i < array.length ; i++) {
            if(i % k == 0) {
                ltr[i] = array[i];
            } else {
                ltr[i] = Math.max(ltr[i-1], array[i]);
            }
        }

        //Construct the right to left array in chunks for window size
        for(int i = array.length-1 ; i > 0 ; i--) {
            if(i == array.length-1) {
                rtl[i] = array[i];
            } else if((i+1) % k == 0) {
                rtl[i] = array[i];
            } else {
                rtl[i] = Math.max(rtl[i+1], array[i]);
            }
        }

        for(int i = 0 ; i < windowNumber ; i++) {
            slidingWindowMaxValues[i] = Math.max(rtl[i], ltr[i + k -1]);
        }

        for(int i = 0 ; i < windowNumber; i++) {
            System.out.println(slidingWindowMaxValues[i] + "->>");
        }
    }

    //TODO Implement using a self balancing binary search tree
    @Override
    public void findSmallerOnRight(int[] array) {

    }

    //Use of Hash Map, time complexity O(1), space complexity O(n) for the hash map
    @Override
    public void subArraySum(int[] array, int sum) {
        int currentSum = 0;
        int flag = 0;
        Map<Integer, Integer> difference = new HashMap<>();

        for(int i = 0 ; i < array.length ; i++) {
            //Gets the consecutive sum till this point in the array
            currentSum += array[i];

            //If the sum till this point equals the sum amount, then sub arrays is between zero and the current index value
            if(currentSum == sum) {
                System.out.println("The sum sub array found between the indices = "+i+" & "+0);
                flag = 1;
                break;
            }

            //
            if(difference.containsKey(currentSum-sum)) {
                System.out.println("The sum sub array found between the indices = "+(difference.get(currentSum-sum)+1)+" & "+i);
                flag = 1;
                break;
            }
            difference.put(currentSum, i);
        }
        if(flag == 0) {
            System.out.println("No such sub array exists");
        }
    }

    //Use an Auxiliary sum array along with hash map with key as sum array key at an index and value as the index itself
    //Time complexity O(n) and space complexity O(n)
    @Override
    public void largestSubArrayEqualBinary(int[] array) {
        int[] sumArray = new int[array.length];
        Map<Integer, Integer> presenceMatrix = new HashMap<>();
        int size = 0;
        int getLow = 0;
        int getHigh = 0;
        //Replace zero with minus one in the input array
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] == 0) {
                array[i] = -1;
            }
        }

        int sumTemp = 0;
        //Populate the sum till index array
        for(int i = 0 ; i < sumArray.length ; i++) {
            sumTemp += array[i];
            sumArray[i] = sumTemp;
        }

        //Iterate over the sum till index array
        for(int i = 0 ; i < sumArray.length ; i++) {
            //If element at index not present in the hash, then add it there
            if(!presenceMatrix.containsKey(sumArray[i])) {
                presenceMatrix.put(sumArray[i], i);
            } else {
                //If the size of the new found pair is bigger, update the range with low and high
                if(i-presenceMatrix.get(sumArray[i]) > size) {
                    getHigh = i;
                    getLow = presenceMatrix.get(sumArray[i])+1;
                    size = (i - presenceMatrix.get(sumArray[i]));
                }
                //Value of low and high at the end of final iteration will give the biggest range with equal binaries
            }
        }
        System.out.println("The largest sub array with the equal number of binary elements is low = "+getLow+" high = "+getHigh);
    }

    //Time complexity is O(n) and space complexity is O(n)
    @Override
    public void productArrayNoDiv(int[] array) {

        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];

        int tempProd = array[0];
        leftProduct[0] = tempProd;
        for(int i = 1 ; i < array.length ; i++) {
            tempProd *= array[i];
            leftProduct[i] = tempProd;
        }
        tempProd = array[array.length-1];
        rightProduct[array.length-1] = tempProd;
        for(int i = array.length-2 ; i > -1 ; i--) {
            tempProd *= array[i];
            rightProduct[i] = tempProd;
        }

        //Make use of left and right product arrays to print the elements of the actual product array
        for(int i = 0 ; i < array.length ; i++) {
            if(i == 0) {
                System.out.println(rightProduct[i+1]);
            } else if (i == array.length -1) {
                System.out.println(leftProduct[i-1]);
            } else {
                int result = leftProduct[i-1] * rightProduct[i+1];
                System.out.println(result);
            }
        }
    }

    //Make use of natural logs to improve the space complexity to O(1)
    @Override
    public void productBetter(int[] array) {
        double complementSeed = 1e-9; //Used to counter the rounding off of the integers by the compiler
        double sum = 0;

        //Post termination of the loop the sum variable shall contain value equivalent to Log(x) where x = a.b.c.d...
        for(int i = 0 ; i < array.length ; i++) {
            sum += Math.log10(array[i]);
        }

        //Value x from the sum amount can be fetched back by taking anti log, which is 10 to the power of sum
        //Hence to get the anti log of the value without the present element we apply the power function by subtracting
        //the current element value
        for(int i = 0 ; i < array.length ; i++) {
            int result = (int) (complementSeed + Math.pow(10.00, (sum - Math.log10(array[i]))));
            System.out.println(result);
        }
    }

    //O(n) time complexity and O(1) space complexity
    @Override
    public void xorArray(int[] array) {
        int xor = array[0];

        //Find the xor of all the elements
        for(int i = 1 ; i < array.length ; i++) {
            xor ^= array[i];
        }

        //Xor the value of total xor with the individual element to cancel it out and hence find the desired result
        for(int i = 0 ; i < array.length ; i++) {
            System.out.println(xor ^ array[i]);
        }
    }

    //TODO Implement later
    @Override
    public void sortNearlySorted(int[] array) {

    }

    //Time complexity O(n) and time complexity O(1)
    //Iterate over array, goto the index equals to the value of current array element, make it negative, if it's already
    //negative then the array element is repeating
    @Override
    public void findDuplicate(int[] array) {

        for(int i = 0 ; i < array.length ; i++) {
            if(array[Math.abs(array[i])] >= 0) {
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            } else {
                System.out.println(Math.abs(array[i]));
            }
        }
    }

    /**
     * Array has n+2 elements where each element ranges from 1 to n inclusive at boundaries
     * All elements from 1 to n occur at least once except the two numbers which repeat, find the repeating numbers
     * Shall make use of solving equations, another good approach is making use of XOR operations
     * @param array
     */
    @Override
    public void findRepeatDuplicates(int[] array) {
        int x;
        int y;
        int deltaOne;
        int deltaTwo;
        int deltaThree;
        int size = array.length - 2;
        int arraySum = 0;
        int naturalSum;
        int arrayMul = array[0];
        int naturalMul = 1;
        for(int i = 0 ; i < array.length ; i++) {
            arraySum += array[i];
        }
        naturalSum = (size*(size+1))/2;
        deltaOne = arraySum - naturalSum; //x+y

        for(int i = 1 ; i < array.length ; i++) {
            if(i < array.length - 2) {
                naturalMul *= (i+1);
            }
            arrayMul *= array[i];
        }
        deltaTwo = arrayMul/naturalMul; //x*y
        deltaThree = (int)Math.sqrt((deltaOne*deltaOne) - 4*(deltaTwo)); // x-y
        x = (deltaOne+deltaThree)/2;
        y = deltaTwo/x;
        System.out.println("Repeating numbers are = "+y+" and "+x);
    }
}