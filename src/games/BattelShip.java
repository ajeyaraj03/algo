package games;

import java.util.Scanner;

/**
 * Created by ajeya.hb on 13/08/16.
 */
public class BattelShip {
    public static void  main(String [] args)
    {

        int dashboardSize = 0;
        int noOfShips = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dashboard matrix size");
        if(scanner.hasNextLine()) {
            dashboardSize = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Choose how many ships to be placed in game");
        if(scanner.hasNextLine()) {
            noOfShips = Integer.parseInt(scanner.nextLine());
        }

        Player player1 = new Player(dashboardSize, "Ajeya");
        Player player2 = new Player(dashboardSize, "Ramu");
        System.out.println("Enter the ships for "+player1.getName()+" in for x1,y1,x2,y2");
        placeShipsForPLayer(player1, scanner, dashboardSize, noOfShips);
        System.out.println("Enter the ships for "+player2.getName()+" in for x1,y1,x2,y2");
        placeShipsForPLayer(player2, scanner, dashboardSize, noOfShips);
        System.out.println("Ships are placed.   3attempts Winner is decided maximum number of hits Lets start the play=====");
        System.out.println("Boards");
        System.out.println(player1.getName()+"Board");
        player1.viewBoard();
        System.out.println(player2.getName()+"Board");
        player2.viewBoard();

        Player player = player1;
        int swicthPlayer = 0;
        while(true)
        {

            System.out.println(player.getName()+"Please enter coordinates to hit the ship x1,y1");
            if(scanner.hasNextLine())
            {
                String data = scanner.nextLine();
                player = player == player1? player2:player1;

                if(player.play(data.split(",")))
                {
                    System.out.println(" It's Hit");
                    player.viewBoard();
                    player = player == player1? player2:player1;
                    player.setHits(player.getHits()+1);
                    player = player == player1? player2:player1;

                }
                else {
                    System.out.println("Its a miss");
                }
                if(swicthPlayer == 1)
                {
                   if(chooseWiner(player1, player2))
                   {
                       break;
                   }
                }
                swicthPlayer = swicthPlayer == 1? 0:1;


            }




        }



//        do{
//
//            System.out.println("Enter data : \n 1 for ship set up \n 2 for play the game \n 0 for exit");
//            switch (Integer.parseInt(scanner.nextLine()))
//            {
//                case 1:
//                    System.out.println("entered 1");
//                    break;
//                case 2:
//                    System.out.println("Entered 2");
//                    break;
//
//                case 0:
//                    System.out.println("Exit");
//                    break;
//
//
//            }
//
//
//
//        }while(true);
//        while(scanner.hasNextLine()) {
//
//            System.out.println("Enter the size of the matrix");
//            if (scanner.hasNextLine()) {
//                sizeOfMatrix = Integer.parseInt(scanner.nextLine());
//            }
//
//            int[][] ship = new int[sizeOfMatrix][sizeOfMatrix];
//
//            System.out.println("Enter the ");
//        }

    }

    private static boolean chooseWiner(Player player1, Player player2) {
        if(player1.getHits() > player2.getHits())
        {
            System.out.println(player1.getName()+"Has won the match ");
            return true;
        }
        else if(player1.getHits() < player2.getHits())
        {
            System.out.println(player2.getName()+"Has won the match ");
            return true;
        }
        else
        {
            System.out.println("It's tie game will continue");
            return false;
        }
    }


    private static void placeShipsForPLayer(Player player, Scanner scanner, int dashboardSize, int noOfShips) {


        while(scanner.hasNextLine()) {

            String player1DataString = scanner.nextLine();

            String [] player1ShipData = player1DataString.split(",");
            if(player1ShipData.length > 4)
            {
                throw new RuntimeException("You have entered more than two coordinates");
            }

            populateShip(player, dashboardSize, player1ShipData);
            if(player.getNoOfships() == noOfShips)
            {
                break;
            }
        }

    }

    private static void populateShip(Player player, int dashboardSize, String[] player1ShipData) {
        player.placeTheships(player1ShipData);

    }

}
