package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.GameObjects.Player.Ruben;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.ScenariumObject;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Game {

    private Field grid = new Field();

    private GameKeyboard keyboard;

    private Collidables[] collidables;

    private int delay;

    private Ruben ruben;

    private boolean gameOn;

    private ScenariumObject[] objects = {


            new Mountains(0, 240, this.grid),
            new Mountains(120, 240, this.grid),
            new Mountains(240, 240, this.grid),
            new Mountains(360, 240, this.grid),
            new Mountains(480, 240, this.grid),
            new Mountains(600, 240, this.grid),
            new Clouds(240, 60, this.grid)};


    public Game(int delay) {

        this.delay = delay;


    }

    public void init() {

        grid.getScorePanel().show();
        ruben = new Ruben(60, 420, grid);
        keyboard = new GameKeyboard(ruben,this);
        keyboard.controls();

    }

    public void start() {

        while (true) {

            pause();
            moveAll();
            ruben.move();

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

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean on){
        this.gameOn = on;
    }
}






