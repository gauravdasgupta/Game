package com.battleship.java.factory;

import com.battleship.java.player.Player;

public class PlayerFactory {
    private Player player;
    public Player getPlayer(String name){
        player= new Player(name);
        return player;
    }
}
