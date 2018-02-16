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

    //O(n) time complexity and O(1) space complexity
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


}