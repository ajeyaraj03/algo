package games;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 09/09/16.
 */
public class FindUniquePathObstacles {

    public static void main(String [] args)
    {

        List<String> pathList = new ArrayList<>();
        List<List<Integer>>  matrix = prepareMatrix(3,3);
        matrix.get(1).set(1,1);
        noOfUniqPaths(matrix, 0, 0, "", pathList);
        System.out.println(pathList);
    }

    private static List<List<Integer>> prepareMatrix(int rowsize, int colsize) {

        List<List<Integer>> matrix = new ArrayList<>();

        for(int row = 0 ; row < rowsize; row++)
        {
            List<Integer> data = new ArrayList<>();
            for(int col = 0 ; col < colsize; col++)
            {
                data.add(0);
            }
            matrix.add(data);
        }

        return matrix;
    }

    public static  void noOfUniqPaths(List<List<Integer>> maxtrix, int row, int col, String path, List<String> pathList)

    {
        path +="("+row+","+col+")";
        if( row > maxtrix.size()-1 || col > maxtrix.get(0).size()-1)
        {
            return;
        }
        else if(maxtrix.get(row).get(col) == 1)
        {
            return;
        }
        else if(row == maxtrix.size()-1 && col == maxtrix.get(0).size()-1)
        {
            pathList.add(path);
        }


        noOfUniqPaths(maxtrix, row, col+1, path, pathList);
        noOfUniqPaths(maxtrix, row+1, col, path, pathList);

    }
}
