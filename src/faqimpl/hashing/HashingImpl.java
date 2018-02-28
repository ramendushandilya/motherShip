package faqimpl.hashing;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

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

    //Use of hashing method
    //Time complexity O(n)+O(m), Space complexity O(m)
    @Override
    public void isDisjoint(int[] arrayOne, int[] arrayTwo) {
        int flag = 0;
        //create a hash set of all the elements of the array one
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < arrayOne.length ; i++) {
            set.add(arrayOne[i]);
        }

        //Search every element in the array two in the hash set
        for(int i = 0 ; i < arrayTwo.length ; i++) {
            if(set.contains(arrayTwo[i])) {
                flag = 1;
                System.out.println("Not disjoint");
                break;
            }
        }
        if(flag == 0)
            System.out.println("Is disjoint");
    }

    //Input {5, 3, 5, 1, 3, 3} should be changed to {5, 5, 3, 3, 3, 1}
    //Time complexity is O(n), space complexity is O(n) for the linked hash map at max in the worst case
    @Override
    public void groupMultipleByOrder(int[] array) {
        //Create a linked hash map to store the frequency of the elements in the array
        LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for(int i = 0 ; i < array.length ; i++) {
            //Check is the element is contained in the map or not, if yes increment the count of it
            if(frequencyMap.containsKey(array[i])) {
                int count = frequencyMap.get(array[i]);
                count++;
                frequencyMap.put(array[i], count);
            } else {
                frequencyMap.put(array[i], 1); //Else initialise the count to one
            }
        }
        //Get the key set for the map
        Set<Integer> keys = frequencyMap.keySet();int count = 0;
        //Iterate through the key set and print elements based on their count in the map
        //Here two for loops don't make the complexity as quadratic rather it's linear since every array element is
        //covered exactly once
        for(Integer key : keys) {
            for(int i = 0 ; i < frequencyMap.get(key); i++) {
                System.out.print(key+"-");
            }
        }
    }


}