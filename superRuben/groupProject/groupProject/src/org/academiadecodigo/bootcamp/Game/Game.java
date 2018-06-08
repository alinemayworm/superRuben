package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.ScenariumObjects.ScenariumObject;

public class Game extends GameKeyboard {

    private Field grid = new Field(720, 600);


    private Collidables[] collidables;

    private int delay;
    private ScenariumObject[] objects = {

            new Mountains(0, 240, grid),
            new Mountains(120, 240, this.grid),
            new Mountains(240,240,this.grid),
            new Mountains(360, 240, grid),
            new Mountains(480, 240, this.grid),
            new Mountains(600,240,this.grid),

            new Clouds(240, 60, grid)};

    private Player player;

    public Game(int delay) {

        this.delay = delay;


    }


    public void init() {





    }

    public void start() {

        while(true) {


            pause();

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

        for (ScenariumObject s : objects){

        s.move();

    }

}

}



