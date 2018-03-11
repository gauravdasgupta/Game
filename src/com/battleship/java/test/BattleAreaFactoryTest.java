package com.battleship.java.test;

import com.battleship.java.factory.BattleAreaFactory;
import com.battleship.java.shipcell.ShipCell;

import static org.junit.Assert.*;

public class BattleAreaFactoryTest {
    int width;
    int height;
    BattleAreaFactory battleAreaFactory;
    ShipCell[][] expectedBattleArea;

    @org.junit.Before
    public void setUp() throws Exception {
        width=2;
        height=1;
        battleAreaFactory = new BattleAreaFactory();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getShipCell() {
        ShipCell[][] expectedBattleArea= new ShipCell[width][height];
        expectedBattleArea=battleAreaFactory.getShipCell(width,height);
        assertSame(expectedBattleArea, expectedBattleArea);
    }
}