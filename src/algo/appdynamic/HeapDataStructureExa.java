package algo.appdynamic;

import java.lang.reflect.Array;

/**
 * Created by ajeya.hb on 13/09/16.
 */
public class HeapDataStructureExa {

    public static void main(String[] args)
    {
        MinHeap<Data> data = new MinHeap<>(Data.class, 10);
    }
}


class MinHeap <T extends Comparable<? super T>>
{
    private T [] data ;
    private int size;
    public MinHeap(Class<T> tClass, int size)
    {
        this.data = (T[])Array.newInstance(tClass, size);
        this.size = size;
    }


    public void insert(T input)
    {
        if(size ==0)
        {
            data[size]=input;
        }
        else
        {
         data[size++] = input;
            if(size > 1) {
                heapify(size-1);
            }
        }
    }


    public T delete(T input)
    {
        int deleteindex =0;
        for(int j= 0 ; j < size; j++)
        {
            if(data[j].equals(input))
            {
                deleteindex = j;
            }
        }
        if(deleteindex == 0)
        {
            return null;
        }else
        {
            T tmp = data[deleteindex];
            data[deleteindex]= data[size-1];
            heapify(deleteindex);
            return tmp;
        }
    }
//left=2i+1, right=2i+2, parent=i-1/2
    private void heapify(int index) {

        int parent = (index-1)/2;
        int left = 2*index+1;
        int right = 2*index+2;

        if(data[parent].compareTo(data[index]) > 0)
        {
            T tmp = data[parent];
            data[parent] = data[index];
            data[index] = tmp;
            heapify(parent);

        }

        else if(left <size && data[left].compareTo(data[index]) > 1)
        {
            T tmp = data[left];
            data[left] = data[index];
            data[index] = tmp;
            heapify(index);
            heapify(left);

        }


    }

}


class Data implements Comparable<Data>{

    @Override
    public int compareTo(Data o) {

        return this.indexData < o.indexData? -1 : this.indexData == this.indexData? 0 : 1;
    }

    private int indexData;
    private Integer value;

    public int getIndexData() {
        return indexData;
    }

    public void setIndexData(int indexData) {
        this.indexData = indexData;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;

        Data data = (Data) o;

        if (getIndexData() != data.getIndexData()) return false;
        return getValue() != null ? getValue().equals(data.getValue()) : data.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getIndexData();
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }
}