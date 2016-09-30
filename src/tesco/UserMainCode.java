package tesco;
import java.io.*;
import  java.util.*;

// Read only region start
class UserMainCode {

    public String GetSubString(String input1, String input2) {
        // Read only region end

        int min =0;
        int max =0;

        System.out.println(input2.length());
        List<Integer> data = new ArrayList<>();
        Map<String, List<Integer>> indexData = new HashMap<>();

        for (int i = 0; i < input2.length(); i++) {

            //String "asd";


            int index = input1.indexOf(input2.charAt(i));
            while (index >= 0) {
                System.out.println("index" + index);
                data.add(index);

                index = input1.indexOf(input2.charAt(i), index + 1);
            }

            indexData.put(String.valueOf(input2.charAt(i)), data);
            data = new ArrayList<>();
        }

        System.out.println(indexData);

        //throw new UnsupportedOperationException("GetSubString(String input1,String input2)");
        return "";
    }
}