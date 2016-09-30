package games;

/**
 * Created by ajeya.hb on 13/08/16.
 */
public class Player {

    private int [] [] board;
    private int noOfships;
    private String  name;
    private int hits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(int sizeOfBoard, String name)
    {
        board = new int[sizeOfBoard][sizeOfBoard];
        this.name = name;
        init(sizeOfBoard);
    }

    public void viewBoard(){

        for(int i=0; i< board[0].length; i++)
        {
            for(int j =0; j< board[0].length;j++)
            {
                System.out.print(board[i][j]);
                System.out.println("("+i+","+j+")");
                System.out.print("||||||");
            }
        }


    }

    public boolean play(String [] data){


        if(board[Integer.parseInt(data[0])][Integer.parseInt(data[1])] == 1)
        {
            board[Integer.parseInt(data[0])][Integer.parseInt(data[1])]=5;

            return true;
        }
        return false;
    }

    public void placeTheships(String [] shipData)
    {

        boolean horizantalPlacing = shipData[1].equalsIgnoreCase(shipData[3]);
        boolean verticalPlacing = shipData[0].equalsIgnoreCase(shipData[2]);

        if(!(horizantalPlacing || verticalPlacing))
        {

            throw new RuntimeException("Only horizantal or vertical placing of ships is allowed");
        }
        if(horizantalPlacing) {
            horizantalPlacing(shipData);
        }else {
            verticalPlacing(shipData);
        }
        noOfships++;

    }

    public void init(int matrixSize)
    {
        for(int i = 0 ;i < matrixSize;i++)
        {
            for(int j = 0; j < matrixSize; j++)
            {
                board[i][j]=0;
            }
        }
    }

    private void verticalPlacing(String[] shipData) {

        System.out.println("In vertical spacing");
        for(int i =Integer.parseInt(shipData[1]); i<= Integer.parseInt(shipData[3]) ;i++)
        {
            System.out.println("iTh value"+i);
            board[Integer.parseInt(shipData[0])][i] = 1;
        }

    }

    private void horizantalPlacing(String[] shipData) {
        System.out.println("In horitantal spacing");
        for(int i =Integer.parseInt(shipData[0]); i<= Integer.parseInt(shipData[2]) ;i++)
        {
            System.out.println("iTh value"+i);
            board[i][Integer.parseInt(shipData[1])] = 1;
        }

    }


    public int getNoOfships() {
        return noOfships;
    }

    public void setNoOfships(int noOfships) {
        this.noOfships = noOfships;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
