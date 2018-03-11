package com.battleship.java.combat;

import com.battleship.java.player.Player;

public interface MissileFunctions {
    boolean hitTarget(Player attacker, Player target);
    boolean fireMissile(String Missile, Player target);
}
