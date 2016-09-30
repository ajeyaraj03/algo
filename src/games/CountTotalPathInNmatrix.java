package games;

/**
 * Created by ajeya.hb on 09/09/16.
 */
public class CountTotalPathInNmatrix {

    static  int count = 0;
    public static void main(String [] args)
    {
        noOfUniqPaths(4, 1, 1);
        System.out.println(count);
    }

    public static  void noOfUniqPaths(int maxtrixSize, int row, int col)
    {
        if(row == maxtrixSize && col == maxtrixSize)
        {
            count ++;
        }
        else if( row > maxtrixSize || col >maxtrixSize)
        {
            return;
        }

        noOfUniqPaths(maxtrixSize, row+1, col);
                noOfUniqPaths(maxtrixSize, row, col+1);
    }
}
