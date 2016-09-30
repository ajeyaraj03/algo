package algo;

import java.util.Scanner;

/**
 * Created by ajeya.hb on 05/08/16.
 */
public class FactorialN {

    public static void main(String [] args)
    {
/*

3! = 1*2*3 =6




 */
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(factorial(number));

    }

    public static int factorial(int n)
    {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
