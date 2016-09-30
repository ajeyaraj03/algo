package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ajeya.hb on 02/08/16.
 */
public class LastMathDoublyLinkedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last mth value and string 'exec' for run the program");
        int lastMth = 0;
        DoubleLinkedList currentPointer = null;
        List<Integer> list = new ArrayList();

if(scanner.hasNextLine())
{
String data = scanner.nextLine();
    if(!data.equalsIgnoreCase("exec"))
    {
        lastMth= Integer.parseInt(data);
    }
    else
    {
        System.out.println("Nothing to execute");
        System.exit(0);
    }
}
        System.out.println("Enter array elements and string 'exec' for execute the program");
        while(scanner.hasNextLine()) {
            String data = scanner.nextLine();

            if (!data.equalsIgnoreCase("exec")) {

                list.add(Integer.parseInt(data));

            }
            else
            {
                System.out.println("Running the program to find the Last Mth element");
                break;
            }
        }



//first element
            int firstINt = list.get(0);


            currentPointer = new DoubleLinkedList(null, firstINt, null);
            for(int i =1; i<list.size(); i++)
            {

                currentPointer = new DoubleLinkedList(currentPointer, list.get(i), null);
                currentPointer.getPreviousPointer().setNextPointer(currentPointer);

            }


            DoubleLinkedList lastMthElement = null;
            //identifies teh last Mth
            for (int i = 0; i < lastMth; i++) {
                lastMthElement = currentPointer.getPreviousPointer();
            }

            System.out.println("Mth element " + lastMthElement.getValue());


   }


}


class DoubleLinkedList{
    private DoubleLinkedList nextPointer;
    private DoubleLinkedList previousPointer;
    private Integer value;

    DoubleLinkedList(DoubleLinkedList previousPointer, Integer value, DoubleLinkedList nextPointer)

    {
        this.nextPointer = nextPointer;
        this.previousPointer = previousPointer;
        this.value = value;
    }

    public DoubleLinkedList getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(DoubleLinkedList nextPointer) {
        this.nextPointer = nextPointer;
    }

    public DoubleLinkedList getPreviousPointer() {
        return previousPointer;
    }

    public void setPreviousPointer(DoubleLinkedList previousPointer) {
        this.previousPointer = previousPointer;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}