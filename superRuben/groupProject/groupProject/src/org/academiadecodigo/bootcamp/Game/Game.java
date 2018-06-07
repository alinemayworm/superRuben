package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.ScenariumObject;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;

public class Game extends GameKeyboard {

    private SimpleGfxGrid grid = new SimpleGfxGrid(720, 600);


    private Collidables[] collidables;

    private int delay;
    private ScenariumObject[] objects = {new Mountains(120, 240, grid), new Mountains(0, 240, this.grid)};

    private Player player;

    public Game(int delay) {

        this.delay = delay;


    }


    public void init() {


        Clouds cloud2 = new Clouds(240, 60, grid);


    }

    public void start() {

        while (true) {


            moveAll();


        }
    }

    public void pause() {

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveAll() {

        for (ScenariumObject s : objects) {
            s.move();
        }


    }


}

