package com.battleship.java.battlearea;

import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

public class DrawBattleArea implements SetupBattle {

    @Override
    public void fillBattleArea(int width, int height, ShipCell[][] battlearea, int x, int y, String shipName, Player player) {
        battlearea[x][y] = new ShipCell(shipName);
        player.setBattlearea(battlearea);

        if(height>1 && width==1){
            for(int i=0;i<height-1;i++){
                this.drawVertical(battlearea,x,y,shipName,player);
            }
        }

        if(height==1 && width>1){
            for(int i=0;i<width-1;i++){
                this.drawHorizontal(battlearea,x,y,shipName,player);
            }
        }
        if(height>1 && width>1){
            for(int i=0;i<height-1;i++){
                this.drawVertical(battlearea,x,y,shipName,player);
            }
            for(int i=0;i<width-1;i++){
                this.drawHorizontal(battlearea,x,y,shipName,player);
            }
        }


    }

    @Override
    public void drawHorizontal(ShipCell[][] battlearea, int x, int y, String shipName,Player player) {
                battlearea[x][++y] = new ShipCell(shipName);
                player.setBattlearea(battlearea);
    }

    @Override
    public void drawVertical(ShipCell[][] battlearea, int x, int y, String shipName,Player player) {
        battlearea[++x][y] = new ShipCell(shipName);
        player.setBattlearea(battlearea);
    }
}
