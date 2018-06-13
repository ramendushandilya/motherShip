package datastructures.array.rotation;

/**
 * @author failedOptimus
 */
public interface RotationInterface {

    int searchElementInSortedRotatedArray(int[] array, int key, int low, int high);
    int rotateBitsOfNumber(int number, int bits);
    void leftRotate(int[] array, int k);
}