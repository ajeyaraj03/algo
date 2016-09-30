package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 07/08/16.
 */
public class SampleINfinitineCoordinates {

//    Note that because the order of covering the points is already defined, the problem just reduces to figuring
// out the way to calculate the distance between 2 points (A, B) and (C, D).
//
//    Note that what only matters is X = abs(A-C) and Y = abs(B-D).
//
//    While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.
//    When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.
//
//    In other words, the total number of steps would correspond to max(X, Y).
        // X and Y co-ordinates of the points in order.
        // Each point is represented by (X.get(i), Y.get(i))
        public static int coverPoints(List<Integer> X, List<Integer> Y) {
            int numSteps = 0;
            for(int i = 1; i < X.size(); i++){
                numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
            }
            return numSteps;
        }

public static void main(String [] args)
{
    //making X coordinates
    List<Integer> xcors = new ArrayList<>();
    xcors.add(-1);
    xcors.add(-6);

    //making Y coordinates
    List<Integer> ycors = new ArrayList<>();
    ycors.add(5);
    ycors.add(-2);

    System.out.println(coverPoints(xcors, ycors));

}

}
