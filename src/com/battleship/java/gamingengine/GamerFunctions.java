package com.battleship.java.gamingengine;

import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

public interface GamerFunctions {
    public void playGame(Player playerA, Player playerB,ShipCell battleareaA[][],
                         ShipCell battleareaB[][],ShipCell emptyRefBattleAreaA[][],ShipCell emptyRefBattleAreaB[][]);
    public void printAttackMessage(Player attacker,String missile,String status);
    public void printFinalResult(String playerName);
}
