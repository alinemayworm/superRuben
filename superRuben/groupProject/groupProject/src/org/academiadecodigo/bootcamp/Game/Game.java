package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.ScenariumObject;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;

public class Game extends GameKeyboard {


    public Game(int delay) {

        grid = new SimpleGfxGrid(36, 30);
        this.delay = delay;

    }


    private SimpleGfxGrid grid;

    private ScenariumObject[] objects;

    private Collidables[] collidables;

    private int delay;

    private Player player;

    public void init() {

        grid.init();

    }

    public void start() {


    }
}

