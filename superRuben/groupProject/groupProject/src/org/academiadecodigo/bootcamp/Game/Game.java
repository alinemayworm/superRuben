package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Beers;
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.GameObjects.Player.Ruben;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.ScenariumObject;


public class Game {

    private Field grid = new Field();

    private GameKeyboard keyboard;

    private Collidables beer = new Beers(610,480,grid);

    private int delay = 150;

    private Ruben ruben;

    private boolean gameOn;

    public void init() {

        grid.getScorePanel().show();
        ruben = new Ruben(60, 420, grid);
        keyboard = new GameKeyboard(ruben, this);
        keyboard.controls();
    }


    private ScenariumObject[] objects = {


            new Mountains(0, 240, this.grid),
            new Mountains(120, 240, this.grid),
            new Mountains(240, 240, this.grid),
            new Mountains(360, 240, this.grid),
            new Mountains(480, 240, this.grid),
            new Mountains(600, 240, this.grid),
            new Clouds(240, 60, this.grid)};


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
        beer.move();
        collisionDetection();


    }

    public void collisionDetection() {
        Beers newbeer = (Beers) beer;


        if ((((((Beers) beer).getBeerImage().getX() <= ruben.getPlayerImage().getX() + 60) &&
                ((Beers) beer).getBeerImage().getX() > ruben.getPlayerImage().getX()) ||

                (((Beers) beer).getBeerImage().getX() + 60 <= ruben.getPlayerImage().getX() + 60) &&
                        ((Beers) beer).getBeerImage().getX() + 60 > ruben.getPlayerImage().getX())

                && ((((

                ((Beers) beer).getBeerImage().getY() <= ruben.getPlayerImage().getY() + 120) &&
                ((Beers) beer).getBeerImage().getY() > ruben.getPlayerImage().getY()) ||

                (((Beers) beer).getBeerImage().getY() + 60 <= ruben.getPlayerImage().getY() + 120)) &&
                (((Beers) beer).getBeerImage().getY() + 60 > ruben.getPlayerImage().getY()))) {


            ((Beers) beer).getBeerImage().delete();

            ((Beers) beer).getBeerImage().translate(610 - ((Beers) beer).getBeerImage().getX(), 0);

        }

    }










    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean on) {
        this.gameOn = on;
    }
}






