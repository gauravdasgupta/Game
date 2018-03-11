package com.battleship.java.commandcentre;

import com.battleship.java.battlearea.DrawBattleArea;
import com.battleship.java.battlearea.SetupBattle;
import com.battleship.java.factory.BattleAreaFactory;
import com.battleship.java.factory.PlayerFactory;
import com.battleship.java.gamingengine.Gamer;
import com.battleship.java.gamingengine.GamerFunctions;
import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

import java.util.*;

public class CommandCentre {


    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        try {
            Integer width;
            Integer height;
            Integer numberOfBattleships;
            ShipCell battleareaA[][] = null;
            ShipCell emptyRefBattleAreaA[][] = null;
            ShipCell battleareaB[][] = null;
            ShipCell emptyRefBattleAreaB[][] = null;
            String inputShipType = "";
            Integer shipInputWidth;
            Integer shipInputHeight;
            String shipACoordinates;
            String shipBCoordinates;
            Integer shipA_Ycoordinate;
            Integer shipA_Xcoordinate;
            Integer shipB_Ycoordinate;
            Integer shipB_Xcoordinate;
            List<String> missileSeqInputP1 = new ArrayList<>();
            List<String> missileSeqInputP2 = new ArrayList<>();
            CommandCentre commandCentre = new CommandCentre();
            BattleAreaFactory battleAreaFactory = new BattleAreaFactory();
            PlayerFactory playerFactory = new PlayerFactory();
            boolean hitSuccess=false;

            width = scanner.nextInt();
            height = ((int)scanner.next().charAt(0))-64;

            battleareaA= battleAreaFactory.getShipCell(width,height);
            battleareaB= battleAreaFactory.getShipCell(width,height);
            emptyRefBattleAreaA= battleAreaFactory.getShipCell(width,height);
            emptyRefBattleAreaB= battleAreaFactory.getShipCell(width,height);

            Player PA = playerFactory.getPlayer("Player-1");
            Player PB = playerFactory.getPlayer("Player-2");


            scanner.nextLine();


            numberOfBattleships = scanner.nextInt();
            scanner.nextLine();


            inputShipType = scanner.next();
            shipInputWidth = scanner.nextInt();
            shipInputHeight = scanner.nextInt();
            shipACoordinates = scanner.next();


            shipA_Ycoordinate = ((int)shipACoordinates.charAt(0))-64;
            shipA_Xcoordinate = Integer.parseInt(String.valueOf(shipACoordinates.charAt(1)))-1;

            shipBCoordinates = scanner.next();

            shipB_Ycoordinate=((int)shipBCoordinates.charAt(0))-64;
            shipB_Xcoordinate = Integer.parseInt(String.valueOf(shipBCoordinates.charAt(1)))-1;

            SetupBattle setupBattle = new DrawBattleArea();
            setupBattle.fillBattleArea(shipInputWidth,shipInputHeight,battleareaA,shipA_Xcoordinate,
                    shipA_Ycoordinate-1,"SHIP_1_A_" + inputShipType,PA);

            setupBattle.fillBattleArea(shipInputWidth,shipInputHeight,battleareaB,shipB_Xcoordinate,
                    shipB_Ycoordinate-1,"SHIP_1_B_" + inputShipType,PB);

            scanner.nextLine();

            inputShipType = scanner.next();
            shipInputWidth = scanner.nextInt();
            shipInputHeight = scanner.nextInt();
            shipACoordinates = scanner.next();

            shipA_Ycoordinate = ((int)shipACoordinates.charAt(0))-64;
            shipA_Xcoordinate = Integer.parseInt(String.valueOf(shipACoordinates.charAt(1)))-1;

            shipBCoordinates = scanner.next();
            shipB_Ycoordinate = ((int)shipBCoordinates.charAt(0))-64;
            shipB_Xcoordinate = Integer.parseInt(String.valueOf(shipBCoordinates.charAt(1)))-1;

            setupBattle.fillBattleArea(shipInputWidth,shipInputHeight,battleareaA,shipA_Xcoordinate,
                    shipA_Ycoordinate-1,"SHIP_2_A_" + inputShipType,PA);

            setupBattle.fillBattleArea(shipInputWidth,shipInputHeight,battleareaB,shipB_Xcoordinate,
                    shipB_Ycoordinate-1,"SHIP_2_B_" + inputShipType,PB);


            scanner.nextLine();
            String missiles_PlayerA=scanner.nextLine();
            String missileSeq_playerA[]=missiles_PlayerA.split(" ");

            for(int i=0;i<missileSeq_playerA.length;i++){
                missileSeqInputP1.add(missileSeq_playerA[i]);
            }

            String missiles_PlayerB=scanner.nextLine();

            String missileSeq_playerB[]=missiles_PlayerB.split(" ");
            for(int i=0;i<missileSeq_playerB.length;i++){
                missileSeqInputP2.add(missileSeq_playerB[i]);
            }

            scanner.close();


            PA.setSequenceOfMissiles(missileSeqInputP1);
            PB.setSequenceOfMissiles(missileSeqInputP2);
            GamerFunctions gamer = new Gamer();
            gamer.playGame(PA,PB,battleareaA,battleareaB,emptyRefBattleAreaA,emptyRefBattleAreaB);


        }
        catch (Exception ex){
            ex.printStackTrace();

        }
        finally {

        }




    }
}
