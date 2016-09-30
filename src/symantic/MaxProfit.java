package symantic;

import java.util.Scanner;

/**
 * Created by ajeya.hb on 13/09/16.
 */
public class MaxProfit {

    public static void main(String [] args)
    {
        int [] data = {10,4,2,1,20};



        System.out.println( findProfit(data));
    }

    private static int findProfit(int[] data) {

        int min =data[0];
        int max = data[0];
        int lessProfit = Math.abs(data[1]- data[0]);
        boolean hasProfit = false;

        for (int i=1; i< data.length; i++)
        {

            if(data[i] < min)
            {
                min = data[i];
                if(Math.abs(data[i]- data[i-1]) < lessProfit)
                {
                    lessProfit = Math.abs(data[i]- data[i-1]);
                }
            }

            if(data[i] > max) {
                max = data[i];
                hasProfit = true;
            }

        }

        return hasProfit? max-min:lessProfit;

    }
}
