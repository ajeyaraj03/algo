package algo.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ajeya.hb on 11/09/16.
 */
public class PoisionPlants {

    public static void main(String [] args)
    {
        Integer [] data = {6,5,8,4,7,10,9};
        List<Integer> datas = Arrays.asList(data);

        System.out.println(calcNoDays(datas, 0));


    }

    private static int calcNoDays(List<Integer> data, int days) {

        boolean noCheck =true;
        List<Integer> newData = new ArrayList<>(data.size());
        for(int i=0; i< data.size(); i++)
        {
            if(i ==0 )
            {
                newData.add(data.get(i));

            }
            else if(data.get(i)-data.get(i-1) < 1)
            {
                newData.add(data.get(i));

            }
            else{
                noCheck = false;
            }
        }
        if(noCheck == true)
        {
            return days;
        }
        return calcNoDays(newData, days+1);
    }
}
