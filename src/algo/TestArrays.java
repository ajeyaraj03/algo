package algo;

/**
 * Created by ajeya.hb on 08/08/16.
 */
public class TestArrays {
    public static void main(String [] args)
    {


        int [] dd = {1,2,3};
        int [] [] ff = {{1,2}, {3,4}};

        int [] empty = new int[2];
        System.arraycopy(dd,1,empty,0,2);

        for(int i =0; i<empty.length; i++)
        {
            System.out.println("gggggg");
            System.out.println(empty[i]);
        }
//        Integer [] sampleData = {};
//        System.out.println((0-1)/2);
//        if(sampleData[0] == null)
//        {
//            System.out.println("Data is null");
//        }
//        System.out.println("sampleData"+ sampleData[0]);
//        Integer [] sample = {1,2,3};
////        System.arraycopy(sample,1,sample,0,2);
////        for (int si :sample)
////        {
////            System.out.println(si);
////        }
//
//        removeElement(sample, 1);
    }

    public static void removeElement(Integer[] array, int index) {
                for (int si :array)
        {
            System.out.println(si);
        }
        int size =array.length;
       // System.arraycopy(array, index+1, array, index, size-index-1);
        size=0;
        System.out.println("before"+size);
        System.out.println(array[size++]);
        System.out.println("after"+size);
        array[--size] = null;
        System.out.println("fff"+array.length);
        System.out.println((3-1)/2);
//                for (int si :array)
//        {
//            System.out.println(si);
//        }


    }
}
