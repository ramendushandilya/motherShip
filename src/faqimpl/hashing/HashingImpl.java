package faqimpl.hashing;

import java.util.HashSet;

public class HashingImpl implements IHashing{

    //Space complexity, O(k), time complexity O(n)
    @Override
    public void checkDupsInDistanceK(int[] array, int k) {
        HashSet<Integer> set = new HashSet<>();
        int flag = 0;
        //Iterate over the array
        for(int i = 0 ; i < array.length ; i++) {
            //If the set contains the element then it's a duplicate in that range
            if(set.contains(array[i])) {
                flag = 1;
                break;
            }
            //If element not present in the set, then add it there
            set.add(array[i]);

            //To make sure that the set size is always of size k, remove the element at the beginning of the set
            if(i >= k) {
                set.remove(array[i-k]);
            }
        }
        if(flag == 1) {
            System.out.println("Contains duplicates");
        } else {
            System.out.println("Doesn't have duplicates");
        }
    }
}