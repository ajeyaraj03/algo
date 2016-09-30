package string;

/**
 * Created by ajeya.hb on 02/09/16.
 */
public class ReverseStringRecursively {

    public static void main(String [] args)
    {
       // StringBuilder data = new StringBuilder("Ajeya");
      //  System.out.println(data.deleteCharAt(2));
        reverse("Ajeya");
    }

    public static void reverse(String data)
    {
        if(data.length() ==0) return;
        StringBuilder obj = new StringBuilder(data);
        System.out.println(obj.charAt(obj.length()-1));
        reverse(obj.deleteCharAt(obj.length()-1).toString());
    }
}
