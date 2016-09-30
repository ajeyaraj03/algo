package games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 09/09/16.
 */
public class FindTheUniquePathsRobot {


    public static void main(String [] args)
    {
       List<String> pathList = new ArrayList<>();
        noOfUniqPaths(2, 1, 1, "", pathList);
        System.out.println(pathList);
    }

    public static  void noOfUniqPaths(int maxtrixSize, int row, int col, String path, List<String> pathList)

    {
        path +="("+row+","+col+")";
        if(row == maxtrixSize && col == maxtrixSize)
        {
            pathList.add(path);
        }
        else if( row > maxtrixSize || col >maxtrixSize)
        {
            return;
        }

        noOfUniqPaths(maxtrixSize, row+1, col, path, pathList);
        noOfUniqPaths(maxtrixSize, row, col+1, path, pathList);
    }
}
