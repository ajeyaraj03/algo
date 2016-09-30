package symantic;

import java.util.*;

/**
 * Created by ajeya.hb on 13/09/16.
 */
public class TestClass {
    public static void main(String args[] ) throws Exception {

        List<Integer> data = new ArrayList<Integer>();
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        Scanner sc = new Scanner(System.in);
        int noOfTestcases = 0;
        int  noOfFrnds = 0;
        int noOfDishes = 0;
        String [] masterAlphabetDataArray = {"a","b","c","d","e","f","g","h","i","j","k","l"
                ,"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        if(sc.hasNextLine())
        {
            noOfTestcases = Integer.parseInt(sc.nextLine());
        }
        if(sc.hasNextLine())
        {
            String [] dataArray = sc.nextLine().split(" ");
            noOfFrnds = Integer.parseInt(dataArray[0]);
            noOfDishes = Integer.parseInt(dataArray[1]);
        }
        //lets have dishes as 1,2,3
        //lets have frnds as a,b
//getting the dishesmap
        Map<Integer,Map<String,String>> dishesLikedBy = new HashMap();

        for(int i =0; i<noOfDishes; i++)
        {
            dishesLikedBy.put(i, new HashMap());
        }

//preparing frnd data
        String [] frndsArray = new String [noOfFrnds];
        for(int j=0; j<noOfFrnds;j++)
        {
            frndsArray[j] = masterAlphabetDataArray[j];
        }

        //accessing the likes input
//tmp map for likes storing
        Map<String,String> tmpData = new HashMap<>();

        for(int k =0 ; k < noOfFrnds; k++)
        {
            if(sc.hasNextLine())
            {

                String [] dishArray = sc.nextLine().split("");
                for(int g=0; g< dishArray.length;g++)
                {
                    if(dishArray[g].equalsIgnoreCase("1"))
                    {
                        if(tmpData.get(frndsArray[k])== null) {
                            tmpData.put(frndsArray[k], frndsArray[k]);
                            dishesLikedBy.get(g).put(frndsArray[k], frndsArray[k]);
                        }

                    }

                }
            }

        }


        //count no of dishes required
        int countDishes=0;
        for( Integer key : dishesLikedBy.keySet())
        {
            if(dishesLikedBy.get(key).size() >0)
            {
                countDishes++;
            }
        }
        System.out.println(countDishes);
    }
}

