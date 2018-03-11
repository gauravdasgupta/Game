package com.battleship.java.factory;

import com.battleship.java.shipcell.ShipCell;

public class BattleAreaFactory {
    private ShipCell battleArea[][];
    public ShipCell[][] getShipCell(int width, int height){
        battleArea=new ShipCell[width][height];
        return battleArea;
    }
}
