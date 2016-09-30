package algo.hackerrank;

import java.util.*;

/**
 * Created by ajeya.hb on 11/09/16.
 */
public class StackHeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 =0;
        int n2 =0;
        int n3 =0;
        String [] sizeArray = new String[3];
        if(in.hasNextLine())
        {
            sizeArray = in.nextLine().split(" ");
        }
        n1 = Integer.parseInt(sizeArray[0]);
        n2 = Integer.parseInt(sizeArray[1]);
        n3 = Integer.parseInt(sizeArray[2]);


        Stack<Integer> h1Stack = new Stack<>();
        Stack<Integer> h2Stack = new Stack<>();
        Stack<Integer> h3Stack = new Stack<>();
        Map<String, Integer> curSumMap = new HashMap(3);
        int minSum = 0;
        String stackname = "h1";
        String [] s1DataArray = new String[n1];
        String [] s2DataArray = new String[n2];
        String [] s3DataArray = new String[n3];

        if(in.hasNextLine())
        {
            s1DataArray= in.nextLine().split(" ");
        }

        for(int h1_i=n1-1; h1_i >= 0; h1_i--){

            h1Stack.enqueue(Integer.parseInt(s1DataArray[h1_i]));
            if(curSumMap.get("h1") != null)
            {
                curSumMap.put("h1", curSumMap.get("h1")+ Integer.parseInt(s1DataArray[h1_i]));

            }
            else
            {
                curSumMap.put("h1", Integer.parseInt(s1DataArray[h1_i]));
            }

        }
        minSum = curSumMap.get("h1");

        if(in.hasNextLine())
        {
            s2DataArray= in.nextLine().split(" ");
        }
        for(int h2_i=n2-1; h2_i >= 0; h2_i--){

            h2Stack.enqueue(Integer.parseInt(s2DataArray[h2_i]));
            if(curSumMap.get("h2") != null)
            {
                curSumMap.put("h2", curSumMap.get("h2")+Integer.parseInt(s2DataArray[h2_i]));
            }
            else
            {
                curSumMap.put("h2", Integer.parseInt(s2DataArray[h2_i]));
            }

        }
        if(curSumMap.get("h2") < minSum)
        {
            minSum = curSumMap.get("h2");
            stackname = "h2";
        }
        if(in.hasNextLine())
        {
            s3DataArray= in.nextLine().split(" ");
        }

        for(int h3_i=n3-1; h3_i >= 0; h3_i--){

            h3Stack.enqueue(Integer.parseInt(s3DataArray[h3_i]));
            if(curSumMap.get("h3") != null)
            {
                curSumMap.put("h3", curSumMap.get("h3")+Integer.parseInt(s3DataArray[h3_i]));
            }
            else
            {
                curSumMap.put("h3", Integer.parseInt(s3DataArray[h3_i]));
            }

        }
        if(curSumMap.get("h3") < minSum)
        {
            minSum = curSumMap.get("h3");
            stackname = "h3";
        }

        Map<String, Stack<Integer>> stackMap = new HashMap<>(3);
        stackMap.put("h1", h1Stack);
        stackMap.put("h2", h2Stack);
        stackMap.put("h3", h3Stack);

        System.out.println(findTheHeight(stackMap, curSumMap, minSum, stackname));






    }

    private static int findTheHeight(Map<String, Stack<Integer>> stackMap, Map<String, Integer> curSumMap, int min, String stack) {

        List<Boolean> matches = new ArrayList<>();
        matches.add(true);
        int newMin = min;
        String newStack = stack;


            for(String stackName : curSumMap.keySet())
            {
                if(!stackName.equalsIgnoreCase(stack))

                {
                    if(curSumMap.get(stackName) == min)
                    {
                        matches.add(true);
                    }
                    else {

                        if (stackMap.get(stackName).getSize() > 0) {

                            int stackValue = stackMap.get(stackName).dequeue();
                            while (curSumMap.get(stackName) - stackValue > min) {
                                curSumMap.put(stackName, curSumMap.get(stackName) - stackValue);
                                stackValue = stackMap.get(stackName).dequeue();
                            }
                            //when not min
                            if (curSumMap.get(stackName) - stackValue == min) {
                                matches.add(true);
                            }
                            curSumMap.put(stackName, curSumMap.get(stackName) - stackValue);
                            if (curSumMap.get(stackName) < newMin) {
                                newMin = curSumMap.get(stackName);
                                newStack = stackName;
                            }

                        }
                    }
                }
            }


            if(matches.size() == 3)
            {
                return newMin;

            }
            else{
             return findTheHeight(stackMap,curSumMap, newMin, newStack);
            }


    }


}

class Stack<T>{

    private TreeNode<T> curNode;
    private TreeNode<T> prevnode;
    private int size;

    public void enqueue(T value)
    {
        if(prevnode ==null)
        {
            prevnode = new TreeNode<>(value, null);
            curNode =prevnode;
            size ++;
        }
        else{

            curNode = new TreeNode<>(value, null);
            curNode.setNextPointer(prevnode);
            prevnode = curNode;
size++;

        }
    }

    public T dequeue()
    {
        TreeNode<T> tmp = prevnode;
        prevnode = curNode.getNextPointer();
        curNode = prevnode;
        size --;
        return tmp.getValue();
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class TreeNode<T>{

    private TreeNode nextPointer;
    private T value;

    public TreeNode(T value, TreeNode<T> nextPointer)
    {
        this.value = value;
        this.nextPointer = nextPointer;
    }

    public TreeNode getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(TreeNode nextPointer) {
        this.nextPointer = nextPointer;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }



}

