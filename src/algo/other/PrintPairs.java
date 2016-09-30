package algo.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ajeya.hb on 08/09/16.
 */
public class PrintPairs {

    static List<Integer> curData = null;
    static List<List<Integer>> finalPairs = new ArrayList<>();
    static Map<Integer, Integer> hashMap= new HashMap();
    static int [] intArray = {1,2,3,4};
    static Queue<List<Integer>> queue = new Queue<>();

    public static void main(String [] args)
    {
for (int j =0 ; j<intArray.length; j++)
{
    hashMap.put(intArray[j], j);
}

        for (int i =0; i<intArray.length;i++)
        {

            List<Integer> data = new ArrayList<>();
            data.add(intArray[i]);
            curData = data;
            finalPairs.add(data);
            if(i < intArray.length -1) {
               // queue.enqueue(data);
                findpairs(i + 1);
            }
        }

        for(List<Integer> integer : finalPairs)
        {
            System.out.println(integer);
        }
    }

    private static void findpairs(int nextPos) {

        if(nextPos > intArray.length)
        {
            return;
        }

        if(nextPos == intArray.length)
        {
            if(queue.size == 0) return;
            curData = queue.dequeue();
            findpairs(hashMap.get(curData.get(curData.size()-1))+1);
        }
        else
        {
            List<Integer> newData = new ArrayList<>();
            newData.addAll(curData);
            newData.add(intArray[nextPos]);
            queue.enqueue(newData);
            finalPairs.add(newData);
            findpairs(nextPos+1);
        }

    }
}


class Queue<T>{

    private TreeNode<T> rootNode;
    private TreeNode<T> currentNode;
    public int size =0;
    public void enqueue(T value)
    {
        if(rootNode == null)
        {
            rootNode = new TreeNode<>(value, null );
            currentNode = rootNode;
        }
        else
        {
            TreeNode treeNode = new TreeNode(value, null);
            currentNode.setNext(treeNode);
            currentNode = treeNode;
        }
        size++;
    }


    public T dequeue()
    {
        if(rootNode == null || currentNode == null) return null;
        T value = rootNode.value;
        rootNode = rootNode.getNext();
        size--;
        return value;
    }

    public int size()
    {
        return size;
    }



}

class TreeNode<T>{

    TreeNode next;
    T value;

    public TreeNode(T value, TreeNode<T> next)
    {
        this.next = next;
        this.value = value;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
