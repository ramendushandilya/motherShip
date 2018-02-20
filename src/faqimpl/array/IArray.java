package faqimpl.array;

/**
 * @author rams0516
 *         Date: 2/16/2018
 *         Time: 4:13 PM
 *         Find the pair of numbers with a given sum
 *         Find the majority element in array, linear way, moore voting algorithm
 *         Find max difference in an array, such that the bigger element comes after the smaller element
 *         Find the number occuring odd number of times in an array assuming that every other element appears even times
 *         Segregate zero and one together in an array which has only zeroes and ones
 */
public interface IArray {

    void findPairSum(int[] array, int sum);

    void findMajLinear(int[] array);

    void findMajMoore(int[] array);

    void maxDifferenceInArrayBigLaterOne(int[] array);

    void maxDifferenceInArrayBigLaterTwo(int[] array);

    void findOddOccuringNumber(int[] array);

    void segregateZeroOne(int[] array);

    void segregateOddEven(int[] array);

    void findElementsSumCloseZero(int[] array);



}