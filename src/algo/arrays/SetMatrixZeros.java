package algo.arrays;

import java.util.*;

/**
 * Created by ajeya.hb on 03/09/16.
 *
 *
 * 1. visit all the data which has zeros and enter in the map
 * 2.One map hold the rows data and other column
 * 3. recursively run the  setting zeros the obtained numbers*/


public class SetMatrixZeros {

    public static void main(String [] args)
    {
        List<Integer> rowData1 = new ArrayList<>(4);
        rowData1.add(1);
        rowData1.add(0);
        rowData1.add(0);
        rowData1.add(0);

        List<Integer> rowData2 = new ArrayList<>(3);
        rowData2.add(1);
        rowData2.add(1);
        rowData2.add(1);

        List<Integer> rowData3 = new ArrayList<>(3);
        rowData3.add(1);
        rowData3.add(0);
        rowData3.add(1);

        List<List<Integer>> data = new ArrayList<>(3);
        data.add(rowData1);
        data.add(rowData2);
        data.add(rowData3);

        setZerosCustom(data);
    }

    private static void setZerosCustom(List<List<Integer>> data) {

        Map<Integer, Integer> rowCoordinates = new HashMap<>(data.size());
        int maxColSize = 0;
        for(int i=0 ; i< data.size(); i++)
        {
            maxColSize = Math.max(maxColSize, data.get(i).size());
        }
        Map<Integer, Integer> colCoordinates = new HashMap<>(maxColSize);

        for(int row = 0 ; row < data.size(); row++)
        {
            for(int col = 0; col < data.get(row).size(); col++)
            {
                System.out.println("row"+row+"col"+col+"data"+data.get(row).get(col));

                if(data.get(row).get(col) == 0)
                {
                    rowCoordinates.put(row, col);
                    colCoordinates.put(col, row);
                }
            }
        }

if(rowCoordinates.size() > 0) setrowsToZero(rowCoordinates, data, maxColSize);
  if(colCoordinates.size() > 0)      setcolRowsToZeros(colCoordinates, data);

        System.out.println("here");
    }

    private static void setcolRowsToZeros(Map<Integer, Integer> colCoordinates, List<List<Integer>> data) {

        Iterator<Map.Entry<Integer, Integer>> it = colCoordinates.entrySet().iterator();

        while(it.hasNext())
        {
            int col = it.next().getKey();
            for(int row = 0 ; row < data.size(); row++)
            {
                if(col < data.get(row).size()) {
                    data.get(row).set(col, 0);
                }
            }
        }
    }

    private static void setrowsToZero(Map<Integer, Integer> rowCoordinates, List<List<Integer>> data, int maxColsize) {

        Iterator<Map.Entry<Integer, Integer>> it = rowCoordinates.entrySet().iterator();

        while(it.hasNext())
        {
int row = it.next().getKey();
            for(int col = 0 ; col < data.get(row).size(); col++)
            {
                data.get(row).set(col, 0);
            }
        }
    }
}
