package games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ajeya.hb on 09/09/16.
 */
public class CountTotalPathMcrossN {

    static  List<String> stringList = new ArrayList<>();
    static List<List<String>> paths = new ArrayList<>();

    public static void main(String [] args)
    {
        System.out.println(noOfunigPath(2, 2, 1, 1));
        System.out.println(paths);
    }

    public static int noOfunigPath(int rowsize, int colSize, int col, int row)
    {
        System.out.println("row"+row +"col"+col);
        stringList.add("row"+row +"col"+col);
        if(row == rowsize && col == colSize)
        {
            System.out.println("am here");
            List<String> data = new ArrayList<>();
            data.addAll(stringList);
            paths.add(data);
        }
        if(row == rowsize ||col ==colSize)
        {
            return 1;
        }

        return noOfunigPath(rowsize, colSize, col+1, row) +noOfunigPath(rowsize, colSize, col, row+1);
    }
}
