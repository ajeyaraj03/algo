package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ajeya.hb on 08/08/16.
 */
public class SubArraySum {
public static void main(String[] args)
{
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(5);
    arrayList.add(2);
    arrayList.add(5);
    maxset(arrayList);

}

        public static ArrayList<Integer> maxset(ArrayList<Integer> a) {

List<List<Integer>> nonPostiveIntegers = new ArrayList<>();
            List<Integer> integers = new ArrayList<>();

           for(int i =0; i< a.size()-1;i++)
           {
               System.out.println("hereeee");
               if(a.get(i) < 0 || a.get(i+1) < 0) {
                   continue;
               }
               else if (a.get(i) < a.get(i+1))
               {
                   integers.add(a.get(i));
                   integers.add(a.get(i+1));
               }
               else{

                   for(int dd: integers)
                   {
                       System.out.println("dasd" +dd);
                   }
                   integers = new ArrayList<>();
               }

           }

            System.out.println(nonPostiveIntegers);

//            Collections.sort(nonPostiveIntegers);
//
//int mid = nonPostiveIntegers.size()/2;
//
//
//
//            for( int as :nonPostiveIntegers)
//            {
//                System.out.println(as);
//            }
            return a;
        }

    static class CustomObject {
        private int sum;
        private List<Integer> elementsLeft = new ArrayList<>();
        private List<Integer> elementsRight = new ArrayList<>();


        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public List<Integer> getElementsLeft() {
            return elementsLeft;
        }

        public void setElementsLeft(List<Integer> elementsLeft) {
            this.elementsLeft = elementsLeft;
        }

        public List<Integer> getElementsRight() {
            return elementsRight;
        }

        public void setElementsRight(List<Integer> elementsRight) {
            this.elementsRight = elementsRight;
        }
    }

}
