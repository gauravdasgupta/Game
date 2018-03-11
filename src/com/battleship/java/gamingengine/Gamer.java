package com.battleship.java.gamingengine;

import com.battleship.java.combat.MissileArea;
import com.battleship.java.combat.MissileFunctions;
import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

import java.util.Arrays;

public class Gamer implements GamerFunctions {
    @Override
    public void playGame(Player playerA, Player playerB, ShipCell[][] battleareaA, ShipCell[][] battleareaB, ShipCell[][] emptyRefBattleAreaA, ShipCell[][] emptyRefBattleAreaB) {
        MissileFunctions missileFunctions = new MissileArea();
        Player attacker = playerA;
        Player target=playerB;
        Player temp = null;
        boolean hitSuccess=false;
        String missile=null;
        do{
            if(!attacker.getSequenceOfMissiles().isEmpty()){
                missile=attacker.getSequenceOfMissiles().get(0);
            }

            hitSuccess=missileFunctions.hitTarget(attacker,target);

            if(hitSuccess){

                this.printAttackMessage(attacker,missile,"hit");


                attacker=attacker;
                target=target;
            }
            else if(!hitSuccess) {

                this.printAttackMessage(attacker,missile,"miss");


                temp=attacker;
                attacker=target;
                target=temp;

            }

            if(Arrays.deepEquals(battleareaA,emptyRefBattleAreaA) || Arrays.deepEquals(battleareaB,emptyRefBattleAreaB)){
                break;
            }
        }
        while(!playerA.getSequenceOfMissiles().isEmpty() || !playerB.getSequenceOfMissiles().isEmpty());

        if(Arrays.deepEquals(battleareaA,emptyRefBattleAreaA)){
            this.printFinalResult("Player-2");
        }
        else if(Arrays.deepEquals(battleareaB,emptyRefBattleAreaB)){
            this.printFinalResult("Player-1");
        }
        else if(!Arrays.deepEquals(battleareaA,emptyRefBattleAreaA) && !Arrays.deepEquals(battleareaB,emptyRefBattleAreaB)){
            System.out.println("Players declare peace");
        }
    }

    @Override
    public void printAttackMessage(Player attacker, String missile, String status) {
        System.out.println(attacker.getName()+" fires a missile with target "+missile+
                " which got "+status);
    }

    @Override
    public void printFinalResult(String playerName) {
        System.out.println(playerName+" won the battle");
    }
}
