package algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 09/08/16.
 */
public class AddOneToNumber {


    public static void main(String[] args)
    {

        List<Integer> integerList = new ArrayList<>();

        integerList.add(0);
//        integerList.add(9);
//        integerList.add(9);
        List<Integer> integers = addOneNumber(integerList);
        for(int a: integers)
        {
            System.out.println(a);
        }
    }

    private static List<Integer> addOneNumber(List<Integer> integerList) {
        int size = integerList.size()-1;

        List<Integer> integers = new ArrayList<>(integerList.size()+1);
        for(int i=0 ; i < integerList.size()+1; i++)
        {
            integers.add(0);
        }


        while(size != -1)
        {
            int data = calIndex(integerList, size);
            if(data == 10)
            {
                integers.set(size+1, 0);
            }
            else
            {
                System.out.println("dsada"+size);
                integers.set(size, data);
                for(int i= size-1; i > -1; i--) {
                    integers.set(i, integerList.get(i));
                }
                integers.remove(size+1);
                break;
            }
            size--;


        }
        if(size == -1)
            integers.set(0, 1);


        return integers;
    }

    public static int calIndex(List<Integer> integerList, int index)
    {
        if(index == -1) return -1;
        int number = integerList.get(index);

        return ++number;
    }
}
