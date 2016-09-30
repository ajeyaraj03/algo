package algo;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 06/08/16.
 */

public class Lift {


public static void main(String[] args)

{
    //2:45
    int [] A = {60,40,80};
    int [] B = {2,3,5};
    int M = 5;
    //max number of ppl
    int X = 2;
    //maximum weight
    int Y = 100;
    System.out.println(solution(A, B, M, X, Y));
}

    private static int solution(int[] A, int[]B, int M, int X, int Y) {
        List<Integer> integerList = new ArrayList<>();
        int currentWeight = 0;
        int currentNumOfItems = 0;
        int totalNumOfTrips = 0;



        for(int i=0 ; i < A.length;i++)
        {
            System.out.println("I"+i);
            try {

                currentWeight += A[i];
                currentNumOfItems++;

                validate(currentNumOfItems, currentWeight, X, Y);
                integerList.add(A[i]);


            }
            catch(RuntimeException e) {
                System.out.println("Called");
                totalNumOfTrips +=countTrip(integerList, B)+1;
                integerList = new ArrayList<>();
                currentNumOfItems = 0;
                currentWeight = 0;
                i--;
            }

        }
        totalNumOfTrips +=countTrip(integerList, B)+1;
        return totalNumOfTrips;
    }

    private static int countTrip(List<Integer> integerList, int[] b) {
        return integerList.size();
    }

    private static void validate(int currentNoOfItems, int currentNoOfWeight, int X, int Y) {

        if(currentNoOfItems > X || currentNoOfWeight > Y)
        {
            throw new RuntimeException("Reached the limit");
        }

    }
}
