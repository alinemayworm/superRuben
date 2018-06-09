package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Beers;
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Birds;
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.GameObjects.Player.Ruben;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.RoadStripes;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.ScenariumObject;


public class Game {

    private Field grid = new Field();

    private GameKeyboard keyboard;

    private int delay = 100;

    private Ruben ruben;

    private boolean gameOn;

    private Collidables currentCollidable;

    public void init() {

        grid.getScorePanel().show();
        ruben = new Ruben(grid);
        keyboard = new GameKeyboard(ruben, this);
        keyboard.controls();
    }


    private ScenariumObject[] objects = {


            new Mountains(0, 240, this.grid, 1),
            new Mountains(120, 240, this.grid, 2),
            new Mountains(240, 240, this.grid, 3),
            new Mountains(360, 240, this.grid, 4),
            new Mountains(480, 240, this.grid, 5),
            new Mountains(600, 240, this.grid, 6),
            new Clouds(180, 60, this.grid),
            new Clouds(420, 170, this.grid),
            new Clouds(600, 120, this.grid),
            new RoadStripes(this.grid)

    };



    public void start() {

        while (true) {

            pause();
            moveAll();
            ruben.move();
            currentCollidable.move();

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

    public void generateCurrentCollidable() {

        Collidables bird = new Birds(600, 380, grid);
        Collidables beer = new Beers(600, 480, grid);

        int random = (int) (Math.random()*2);

        switch (random){
            case 0:
                this.currentCollidable = bird;
                break;

            case 1:
                this.currentCollidable = beer;
                break;
        }
    }


    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean on) {
        this.gameOn = on;
    }


    /*for (int i = 0; i < collidables.length; i++){

        int random = (int) (Math.random()*collidables.length);

        switch (random){
            case 0:

                collidables[i].;


            case 1:

                collidables[]
        }

    }*/
}






