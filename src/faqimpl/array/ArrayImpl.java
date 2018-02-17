package faqimpl.array;

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
        int occurance = 0;

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
                occurance++;
            }
        }
        if(occurance > array.length/2) {
            System.out.println("Majority element is = "+candidate);
        } else {
            System.out.println("No majority element present in the given array");
        }
    }

    //Use of difference array in line with O(n) time complexity, O(1) space complexity
    @Override
    public void maxDifferenceInArrayBigLaterOne(int[] array) {

    }

    //Use of indexes to calculate min so far and max difference
    @Override
    public void maxDifferenceInArrayBigLaterTwo(int[] array) {

    }
}