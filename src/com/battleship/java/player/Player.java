package com.battleship.java.player;

import com.battleship.java.shipcell.ShipCell;

import java.util.List;

public class Player  {
    private ShipCell battlearea[][]= null;
    private List<String> sequenceOfMissiles=null;
    private String name=null;

    public String getName() {
        return name;
    }

    public Player(String name){
        this.name=name;
    }

    public ShipCell[][] getBattlearea() {
        return battlearea;
    }

    public void setBattlearea(ShipCell[][] battlearea) {
        this.battlearea = battlearea;
    }

    public List<String> getSequenceOfMissiles() {
        return sequenceOfMissiles;
    }

    public void setSequenceOfMissiles(List<String> sequenceOfMissiles) {
        this.sequenceOfMissiles = sequenceOfMissiles;
    }



}
