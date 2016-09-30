package algo;

/**
 * Created by ajeya.hb on 09/08/16.
 */
public class SumNonNegArrays {


    public static void main(String[] args)
    {
        int[] array = {1,2,3,-1,3,5,6,7};
        int [] finalArray = calSum(array);
//        int [] newrray =new int[array.length];
//        System.arraycopy(array,1,newrray,0,array.length-1);
//        for(int i=0; i< newrray.length;i++)
//        {
//            System.out.println(newrray[i]);
//        }
        for(int i=0 ; i< finalArray.length;i++)
        {
            System.out.println(finalArray[i]);
        }
    }

    private static int [] calSum(int[] array) {
        int maxSum =0;
        int [] maxArray = {};
        int interArrayIndex = 0;

        int [] interMediateArray = new int[array.length];
        int interMediateSum =0;

        for(int i=0; i< array.length; i++)
        {
            if(array[i] > 0)
            {
                interMediateArray[interArrayIndex++] = array[i];
                interMediateSum+=array[i];
            }
            else
            {
                if(interMediateSum > maxSum)
                {
                    maxSum = interMediateSum;
                    maxArray = interMediateArray;
                    interMediateArray = new int[array.length];
                    interMediateSum = 0;
                    interArrayIndex = 0;
                }
            }
        }
        System.out.println("sum"+interMediateSum);
        if(interMediateSum > maxSum)
        {
            maxSum = interMediateSum;
            maxArray = interMediateArray;
            interMediateArray = new int[array.length];
            interMediateSum =0;
        }
int [] finalArray = new int[interArrayIndex];
        System.arraycopy(maxArray,0,finalArray,0,finalArray.length);
        return finalArray;
    }
}

class DataHolder {

    private int sum;

}
