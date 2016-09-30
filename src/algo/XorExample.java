package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ajeya.hb on 07/09/16.
 */
public class XorExample {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = 0;
        int sizeOfSet = 0;
        String [] requiredSet = null;
        List<List<Integer>> pairs = new ArrayList<>();
        if(sc.hasNextLine())

        {
            numberOfTestCases = Integer.parseInt(sc.nextLine());
        }
        if(sc.hasNextLine())
        {
            sizeOfSet = Integer.parseInt(sc.nextLine());
        }
        if(sc.hasNextLine())
        {
            requiredSet = sc.nextLine().split(" ");
        }

        prepareList(requiredSet);
    }

    private static void prepareList(String[] requiredSet) {
        List<List<Integer>> pairs = new ArrayList<>();

        for(int i=0; i<requiredSet.length; i++)
        {
            int j = 0;
            List<Integer> intDataOriginal = new ArrayList<>();
            while (j < requiredSet.length) {
                List<Integer> intData = new ArrayList<>();

                intData.add(new Integer(i));
            }

        }

        for (String data: requiredSet)
        {

        }
    }


}
