package tesco;

import java.util.*;

/**
 * Created by ajeya.hb on 10/09/16.
 */
public class Test {

    public static void main(String [] args)
    {


        String data = "asd";
        System.out.println(data.substring(0,2));
        System.out.println(getCount());



    }

    private static int getCount() {

        int input1 = 10;
        int input2 = 5;
        int [] [] input3 = {{0,4},{1,5},{7,3}, {2,2},{6,4}};
        int max = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        List<ClothData> finalData = new ArrayList<>();

        for(int row =0 ; row < input3.length; row++)
        {

if(input3[row][0] > max)
            {
                max = input3[row][0];
            }
            if(resultMap.size() != 0 && resultMap.get(input3[row][0])!= null
                    && resultMap.get(input3[row][0]) < input3[row][1])
            {

                finalData.remove(new ClothData(input3[row][0],resultMap.get(input3[row][0])));
                finalData.add(new ClothData(input3[row][0],input3[row][1]));
                	resultMap.put(input3[row][0],input3[row][1]);
            }
            else if(resultMap.size() != 0 && input3[row][0] < max)
            {
                Iterator it = resultMap.entrySet().iterator();
                while (it.hasNext())
                {

                   Map.Entry<Integer, Integer> data = (Map.Entry)it.next();
                    if(data.getKey() > input3[row][0])
                    {
                        if(data.getKey()+data.getValue() >= input3[row][0]+input3[row][1])
                        {
                            finalData.remove(new ClothData(data.getKey(),data.getValue()));

                        }
                    }
                }
                finalData.add(new ClothData(input3[row][0],input3[row][1]));
                resultMap.put(input3[row][0],input3[row][1]);
            }
            else
            {
                resultMap.put(input3[row][0], input3[row][1]);
                finalData.add(new ClothData(input3[row][0],input3[row][1]));
            }


        }
        System.out.println(finalData.size());
        return finalData.size();
    }
}

class ClothData{

    private int startPos;
    private int offset;

    public ClothData(int startPos, int offset)
    {
        this.startPos = startPos;
        this.offset = offset;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothData)) return false;

        ClothData clothData = (ClothData) o;

        if (getStartPos() != clothData.getStartPos()) return false;
        return getOffset() == clothData.getOffset();

    }

    @Override
    public int hashCode() {
        int result = getStartPos();
        result = 31 * result + getOffset();
        return result;
    }
}
