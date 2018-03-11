package com.battleship.java.battlearea;

import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

public interface SetupBattle {
    public void fillBattleArea(int width, int height, ShipCell battlearea[][], int x, int y, String shipName, Player player);
    public void drawHorizontal(ShipCell[][] battlearea, int x, int y, String shipName,Player player);
    public void drawVertical(ShipCell[][] battlearea, int x, int y, String shipName,Player player);
}
