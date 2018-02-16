package faqimpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:13 PM
 */
public class ArrayImpl implements IArray{

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
}