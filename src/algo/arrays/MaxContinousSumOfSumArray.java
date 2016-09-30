package algo.arrays;

/**
 * Created by ajeya.hb on 09/08/16.
 */
public class MaxContinousSumOfSumArray {


    public static void main(String[] args)
    {
        int [] array = { 97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192, -214, -389, -202, -183, -72, -416, -455, -187, -242, -416, 39, -198, -338, -465, -248, -25, -398, -97, -461, -214, -423, -407, -77, -190, -67, -178, -410, -160, 72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17, 60, 19, 80, -218, -28, -426, -366, -140, 50 };



        System.out.println(calculateMaxArray(array));
    }

    private static int calculateMaxArray(int[] array) {
        int currentSum =array[0];
        int maxSum =array[0];

        for (int i=1; i<array.length;i++)
        {
            currentSum = Math.max(array[i],currentSum+array[i]);

            maxSum = Math.max(currentSum,maxSum);

        }
        return maxSum;
    }
}
