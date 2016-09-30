package algo.appdynamic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ajeya.hb on 19/09/16.
 */
public class DataSample {

    public static void main(String [] args)
    {
        Map<Integer, String> stringStringMap = new LinkedHashMap<>(10,0.75f,true);

        stringStringMap.put(8,"ajeya");
        stringStringMap.put(1,"kavya");
        stringStringMap.put(9,"ramya");




        Set<Map.Entry<Integer, String>> entrySet = stringStringMap.entrySet();

       for (Map.Entry<Integer,String> data : entrySet)
       {
           System.out.println(data.getKey());
           System.out.println(data.getValue());
       }
        stringStringMap.get(1);
        stringStringMap.get(8);
       // stringStringMap.put(1,"drama");
        System.out.println("gggggggggg");
        Set<Map.Entry<Integer, String>> entrySet1 = stringStringMap.entrySet();

        for (Map.Entry<Integer,String> data : entrySet1)
        {
            System.out.println(data.getKey());
            System.out.println(data.getValue());
        }
    }
}
