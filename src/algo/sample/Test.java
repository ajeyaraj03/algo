package algo.sample;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by ajeya.hb on 13/09/16.
 */
public class Test {

    public static void main(String [] args)
    {
        Date oldDate = new Date(2015, 2, 12);

        Date newDate = new Date(2016, 2, 12);
        System.out.println(oldDate.getTime());
        System.out.println(newDate.getTime());

        System.out.println(oldDate.compareTo(newDate));

        SortedSet sortedSet = new TreeSet<>();
        Collections.synchronizedSet(sortedSet);
        //concurrent HashMap

        Map<String, Integer> data = new ConcurrentHashMap<>();

        int [] dataArray = {1,2,3,4};
        System.out.println(dataArray[-2]);

        System.out.println(data.putIfAbsent("ajeya", 10));
        System.out.println(data.putIfAbsent("ajeya", 12));
        System.out.println(data);
    }
}
