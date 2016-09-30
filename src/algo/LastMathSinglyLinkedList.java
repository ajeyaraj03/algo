package algo;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ajeya.hb on 02/08/16.
 */
public class LastMathSinglyLinkedList {

    public static void main(String [] args){

        int lastMth = 0;
        List<Integer> list = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Please enter the mth index to find and 'exit' to exit the program");
        if(scanner.hasNextLine())
        {
            String data = scanner.nextLine();
            if(!data.equalsIgnoreCase("exit"))
            {
lastMth = Integer.parseInt(data);
            }
            else
            {
                //System.out.println("Nothing to execute");
                System.exit(0);
            }
        }

        while(scanner.hasNextLine())
        {
            String data = scanner.nextLine();
            if(!data.equalsIgnoreCase("exec"))
            {
                list.add(Integer.parseInt(data));

            }
            else
            {
                System.out.println("The Program is executig to find last Mth element");
                break;
            }
        }

//Executing the program

        SinglyLinkedList<Integer> currentPointer;
        SinglyLinkedList<Integer> originalPointer;
        SinglyLinkedList<Integer> previousPointer;
        SinglyLinkedList<Integer> mthPointer = null;


        originalPointer = new SinglyLinkedList<Integer>(list.get(0), null);
        currentPointer = originalPointer;
mthPointer = originalPointer;
        for(int i=1; i<list.size();i++)
        {

            previousPointer = currentPointer;
            currentPointer = new SinglyLinkedList<Integer>(list.get(i), null);
            previousPointer.setNextPointer(currentPointer);

             if(i >= lastMth)
            {
                mthPointer = mthPointer.getNextPointer();

            }

        }

        System.out.println(mthPointer.getValue());
    }


}

class SinglyLinkedList<T>{


    private SinglyLinkedList nextPointer;
    private T value;

    public SinglyLinkedList(T value, SinglyLinkedList<T> nextPointer)
    {
this.value = value;
        this.nextPointer = nextPointer;
    }

    public SinglyLinkedList getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(SinglyLinkedList nextPointer) {
        this.nextPointer = nextPointer;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
