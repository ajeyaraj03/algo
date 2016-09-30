package algo;

import java.util.Scanner;

/**
 * Created by ajeya.hb on 05/08/16.
 */

/*

0,1,2,3,4,5,6
1,2,3,4,5,6,7


 */
public class BinarySearch {

    public static void main(String [] args)
    {

        int number =0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to search");
        if(scanner.hasNextLine())
        {
            number = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Enter the array by the spaces");
        Integer[] intArrays = null;
        if(scanner.hasNextLine())
        {
            String data = scanner.nextLine();
            String[] arrays = data.split(" ");
            intArrays = new Integer[arrays.length];
            for (int i = 0; i < arrays.length; i++) {
                intArrays[i] = Integer.parseInt(arrays[i]);
            }
        }

        System.out.println(binarySearch(intArrays, number, 0, intArrays.length-1));

    }

    private static boolean binarySearch(Integer[] intArrays, int number, int low, int high) {
        System.out.println("low"+low);
        System.out.println("high"+high);
        System.out.println("ggg"+((low + high)/2));
        System.out.println("number "+intArrays[(low + high)/2]);

        if(low > high)
        {
           return false;
        }
        else if(intArrays[(low + high)/2] == number )
        {
            return true;
        }
        else if (intArrays[((low +high)/2)] < number)
        {
            low =(low +high)/2 +1;

        }
        else
        {
            high = (low +high)/2 -1;
        }
        return binarySearch(intArrays, number, low, high);
    }

    private static class ABc{

    }
}


