package algo.arrays;

import java.util.Scanner;

/**
 * Created by ajeya.hb on 07/09/16.
 */
public class RotateArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        String inputData = null;
        int numberOfTimesToRotate = 0;
        int givenLength = 0;
        if (sc.hasNextLine()) {
            String givenData = sc.nextLine();
            String[] datas = givenData.split(" ");
            numberOfTimesToRotate = Integer.parseInt(datas[1]);
            givenLength = Integer.parseInt(datas[0]);
        }
        if (sc.hasNextLine()) {
            inputData = sc.nextLine();
        }

        String[] inputArray = inputData.split(" ");

        if (inputArray.length != givenLength) {

            throw new RuntimeException("Given and array and length are mismatch");
        }
        String[] outputArray = new String[inputArray.length];

        //copy the remaing elements to outputarray
        System.arraycopy(inputArray, numberOfTimesToRotate, outputArray, 0, inputArray.length - numberOfTimesToRotate);

        //copy teh rotated elementss
        System.arraycopy(inputArray, 0, outputArray, (inputArray.length - numberOfTimesToRotate), numberOfTimesToRotate);

        for (int i = 0; i < outputArray.length; i++) {
            System.out.print(outputArray[i]);
            System.out.print(" ");
        }
    }
}
