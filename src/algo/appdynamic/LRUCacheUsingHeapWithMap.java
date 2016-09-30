//package algo.appdynamic;
//
//import java.util.SortedSet;
//import java.util.TreeSet;
//
///**
// * Created by ajeya.hb on 12/09/16.
// */
//public class LRUCacheUsingHeapWithMap {
//
//
//
//}
//
//
//class LRU{
//
//    private SortedSet<DataWrapper> dataSet = new TreeSet();
//    private Map<String, DateWrapper> dataMap = new Hashmap();
//    private int maxSize = 10;
//
//
//    public void put(String key, Object data)
//    {
//
//
//        if(dataMap.size() == 0)
//        {
//
//            DataWrapper tmpData = new DataWrapper(new Date(), new Date(key,data));
//            dataSet.add(tmpData);
//            dataMap.put(key, tmpData);
//
//        }
//        else
//        {
//            DataWrapper newData = dataMap.get(key);
//
//            if(newData ==null)
//            {
//                DataWrapper tmpData = new DataWrapper(new Date(), new Date(key,data));
//                dataSet.add(tmpData);
//                dataMap.put(key, tmpData);
//
//            }
//            else{
//
//                dataSet.remove(newData);
//
//                newData.setRecentDate(new Date());
//                dataMap.put(key, newData);
//
//                dataSet.add(newData);
//            }
//
//            if(dataSet.size() > maxSize)
//            {
//                DataWrapper removingData = dataSet.last();
//                dataSet.remove(removingData);
//                dataMap.remove(removingData.getValue().getKey());
//            }
//
//        }
//
//    }
//
//    public Object get(String key)
//    {
//
//        return dataMapMap.get(key);
//
//    }
//
//
//}
//
//
//
//class DataWrapper imeplements Comparable{
//
//    private DateTime recentDate;
//    private Data value
//
//    public DataWrapper(DateTime date, Data value)
//    {
//        this.date;
//        this.value;
//    }
//
//    public int compareTo(DataWrapper o)
//    {
//
//        if(this.getRecentDate() > o.getRecentDate()) return -1;
//        if(this.getRecentDate() == o.getRecentDate()) return 0;
//
//        return 1;
//    }
//
//    public DateTime getRecentDate()
//    {
//        this.recentDate;
//    }
//
//    public Data getValue(){
//
//        this.getValue();
//    }
//
//    public setRecentDate(Date date)
//    {
//        this.recentDate = date;
//    }
//
//
//
//
//}
//
//class Data<T,E>{
//
//
//    private T key;
//    private E value;
//
//    public Data(T key, E value)
//    {
//        this.key = key;
//        this.value = value;
//    }
//
//    public T getKey()
//    {
//        this.key;
//    }
//
//    public E get Value()
//    {
//        this.value;
//    }
//
//
//}
//
