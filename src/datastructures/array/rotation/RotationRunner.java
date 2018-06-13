package datastructures.array.rotation;

import datastructures.array.rotation.impl.RotationImpl;

/**
 * @author failedOptimus
 */
public class RotationRunner {

    static int[] array = {4,5,6,7,8,9,1,2,3};
    static RotationInterface rotation = new RotationImpl();

    public static void main(String[] args) {

        System.out.println(rotation.searchElementInSortedRotatedArray(array, 12, 0, array.length-1));
    }
}