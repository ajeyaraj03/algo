package tesco;

import com.sun.tools.javac.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;

import static com.sun.javafx.scene.traversal.Hueristic2D.findMin;

/**
 * Created by ajeya.hb on 10/09/16.
 */
public class StringSearch {


    public static void main(String [] args)
    {
        String input1 = "myri Namemri";
        String input2 = "rim";

        getShortSubstring(input1, input2);
       // findMinData(indexData);
    }

    private static void getShortSubstring(String input1, String input2) {

        System.out.println(input2.length());
        HeapData<StorageData> sortedData = new HeapData<>(StorageData.class,input1.length());

        Map<String, HeapData<Integer>> indexData = new HashMap<>();

        for(int i =0 ; i< input2.length(); i++)
        {

HeapData<Integer> heapData = new HeapData<>(Integer.class,input1.length());

            int index = input1.indexOf(input2.charAt(i));
            while(index >= 0) {
                System.out.println("index"+index);

                heapData.insert(index);
                sortedData.insert(new StorageData(String.valueOf(input2.charAt(i)),index));

                index = input1.indexOf(input2.charAt(i), index+1);
            }

            indexData.put(String.valueOf(input2.charAt(i)),heapData);


        }
        List<SortedSet<Integer>>  lists = calculateMindata(input2, indexData, sortedData);
        HeapData<MinData> minDataHeapData = new HeapData<>(MinData.class, input1.length());

        for(SortedSet<Integer> listsort : lists)
        {

            minDataHeapData.insert(new MinData(listsort, listsort.last()-listsort.first()));
        }
MinData minData = minDataHeapData.getAndRemoveRoot();
        System.out.println("final string"+input1.substring(minData.getInputChar().first(), minData.getInputChar().last()+1));
    }

    private static List<SortedSet<Integer>> calculateMindata(String input2, Map<String, HeapData<Integer>> indexData,
                                         HeapData<StorageData> sortedData) {
        List<SortedSet<Integer>> lists = new ArrayList<>();

        while (sortedData.getSize() > 0)
        {

            StorageData data = sortedData.getAndRemoveRoot();
            System.out.println("remove sor"+data.getIndex());
            String minString = data.getInputChar();
            int minIndex = data.getIndex();
            SortedSet<Integer> numbers = new TreeSet<>();
            numbers.add(data.getIndex());
            for(String nu : indexData.keySet())
            {
                if(!nu.equalsIgnoreCase(data.getInputChar()))
                {
                    if(indexData.get(nu).getRoot() != null)
                    {
                        if (indexData.get(nu).getRoot() < minIndex) {
                            minString = nu;
                            minIndex = indexData.get(nu).getRoot();
                        }
                        numbers.add(indexData.get(nu).getRoot());
                    }
                }
            }
indexData.get(minString).getAndRemoveRoot();
            if(numbers.size() == indexData.size()) {
                lists.add(numbers);
            }

        }
        return lists;

    }


}

class StorageData implements Comparable<StorageData>{
    private String inputChar;
    private int index;

    public StorageData(String inputChar, int index)
    {
        this.inputChar = inputChar;
        this.index = index;
    }

    public String getInputChar() {
        return inputChar;
    }

    public void setInputChar(String inputChar) {
        this.inputChar = inputChar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorageData)) return false;

        StorageData that = (StorageData) o;

        if (getIndex() != that.getIndex()) return false;
        return getInputChar() != null ? getInputChar().equals(that.getInputChar()) : that.getInputChar() == null;

    }

    @Override
    public int hashCode() {
        int result = getInputChar() != null ? getInputChar().hashCode() : 0;
        result = 31 * result + getIndex();
        return result;
    }


    @Override
    public int compareTo(StorageData o) {

        if(this.index < o.index) return -1;
        if(this.index == o.index) return 0;
        return 1;
    }
}


class MinData implements Comparable<MinData>{
    private SortedSet<Integer> inputChar;
    private int index;

    public MinData(SortedSet<Integer>  inputChar, int index)
    {
        this.inputChar = inputChar;
        this.index = index;
    }

    public SortedSet<Integer> getInputChar() {
        return inputChar;
    }

    public void setInputChar(SortedSet<Integer>  inputChar) {
        this.inputChar = inputChar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MinData)) return false;

        MinData minData = (MinData) o;

        if (getIndex() != minData.getIndex()) return false;
        return getInputChar() != null ? getInputChar().equals(minData.getInputChar()) : minData.getInputChar() == null;

    }

    @Override
    public int hashCode() {
        int result = getInputChar() != null ? getInputChar().hashCode() : 0;
        result = 31 * result + getIndex();
        return result;
    }

    @Override
    public int compareTo(MinData o) {

        if(this.index < o.index) return -1;
        if(this.index == o.index) return 0;
        return 1;
    }
}

//Head data left= 2i+1,right= 2i+2 and parent=(i-1/2)
class HeapData<T extends Comparable<? super T>> {

    private T [] data;
    private int size;


    public HeapData (Class<T> tClass, int size)
    {
        this.data = (T[]) Array.newInstance(tClass, size);
    }
    public void insert(T element){
        data[size++] = element;
        heapify(size-1);

    }

    public void delete(T element)
    {
        // System.out.println("found" +element);
        int deleteIndex = -1;
        for(int i=0 ; i< size;i++ )
        {
            if(data[i] == element) {
                deleteIndex =i;
                break;
            }
        }

        // int deleteIndex = Arrays.binarySearch(data, element);

        if(deleteIndex != -1) {
            data[deleteIndex] = data[--size];
            data[size] = null;
            if(size > 0) {
                heapify(deleteIndex);
            }
        }

    }

    public T getAndRemoveRoot()
    {
        if(size == 0) {
            return null;
        }
        else
        {
            T rootData = data[0];
            //  System.out.println("Data "+rootData);
            delete(rootData);
            return rootData;
        }


    }

    public T getRoot()
    {
        if(size == 0) {
            return null;
        }
        else
        {
            T rootData = data[0];
            //  System.out.println("Data "+rootData);
            return rootData;
        }


    }

    private void heapify(int index) {
        int parent = (index-1)/2;
        int left = (2*index +1);
        int right = (2*index +2);
        if(data[parent].compareTo(data[index]) > 0)
        {
            T tmp = data[parent];
            data[parent] = data[index];
            data[index] = tmp;

            heapify(parent);

        }
        else if(left < size && data[left].compareTo(data[index])< 0)
        {
            T tmp = data[left];
            data[left] = data[index];
            data[index] = tmp;
            heapify(index);
            heapify(left);
        }
        else if(right < size && data[right].compareTo(data[index])< 0)
        {
            T tmp = data[right];
            data[right] = data[index];
            data[index] = tmp;
            heapify(index);
            heapify(right);
        }


    }

    public boolean hasData()
    {
        return size > 0? true:false;
    }

    public int getSize() {
        return size;
    }

    public T[] getData() {
        return data;
    }
}
