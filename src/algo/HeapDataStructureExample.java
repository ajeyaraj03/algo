package algo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by ajeya.hb on 08/08/16.
 */

//min heap implementation
public class HeapDataStructureExample {

    public static void main(String [] args)
    {
        HeapData<Integer> heapData = init();


        heapData.insert(2);
       // System.out.println("heapData size"+heapData.getSize());
        Integer [] data = heapData.getData();
        for(int i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }

       while(heapData.hasData())
       {
           System.out.println(heapData.getAndRemoveRoot());
       }
    }

    private static HeapData<Integer>  init() {
        HeapData<Integer> heapData = new HeapData<>(Integer.class, 10);
        for(int i = 11; i < 15; i++)
        {
            heapData.insert(i/2);
            
            
        }
        return heapData;
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