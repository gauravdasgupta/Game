package com.battleship.java.test;

import com.battleship.java.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerFactoryTest {
    String name="";

    @Before
    public void setUp() throws Exception {
        name="Player-1";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPlayer() {
        Player actualPlayer = new Player(name);
        assertNotNull(actualPlayer);

    }
}