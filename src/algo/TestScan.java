package algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ajeya.hb on 05/08/16.
 */
public class TestScan {

    public static void main(String [] args)
    {


        Scanner scanner = new Scanner(System.in);
        System.out.println("First 1");
        if(scanner.hasNextLine())
        {
            System.out.println(11/2);
        }
        System.out.println("First 2");
        if(scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }
    }
}

