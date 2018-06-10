package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Beers;
<<<<<<< HEAD
=======
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Birds;
>>>>>>> aline
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.GameObjects.Player.Ruben;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.RoadStripes;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.ScenariumObject;

public class Game {

    private Field grid = new Field();

    private GameKeyboard keyboard;

<<<<<<< HEAD
    private Collidables beer = new Beers(610,480,grid);

    private int delay = 150;
=======
    private int delay = 100;
>>>>>>> aline

    private Ruben ruben;

    private boolean gameOn = true;

    private Collidables currentCollidable;

    Collidables bird = new Birds(grid);
    Collidables beer = new Beers(grid);

    public void init() {

        grid.getScorePanel().show();
        ruben = new Ruben(grid);
        keyboard = new GameKeyboard(ruben, this);
        keyboard.controls();
        generateCurrentCollidable();
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

        while (gameOn) {

            pause();
            moveAll();
            if (ruben.isDead()) {
                setGameOn(false);
            }
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
<<<<<<< HEAD
        beer.move();
        collisionDetection();
=======
        if (currentCollidable.isCurrent() && !currentCollidable.isCrashed()) {
            currentCollidable.move();
            collisionDetection(ruben);
        } else {
            generateCurrentCollidable();
        }

        ruben.move();
>>>>>>> aline

    }

    public void generateCurrentCollidable() {

        int random = (int) (Math.random() * 2);


        switch (random) {
            case 0:
                this.currentCollidable = beer;
                currentCollidable.getCollidablePicture().translate(610-currentCollidable.getMinX(),0);
                currentCollidable.setCurrent(true);
                currentCollidable.setCrashed(false);
                currentCollidable.getCollidablePicture().draw();
                currentCollidable.setPosition(currentCollidable.getMinX(),currentCollidable.getMinY(),currentCollidable.getMaxX(),currentCollidable.getMaxY());
                break;

            case 1:
                this.currentCollidable = bird;
                currentCollidable.getCollidablePicture().translate(610-currentCollidable.getMinX(),0);
                currentCollidable.setCurrent(true);
                currentCollidable.setCrashed(false);
                currentCollidable.getCollidablePicture().draw();
                currentCollidable.setPosition(currentCollidable.getMinX(),currentCollidable.getMinY(),currentCollidable.getMaxX(),currentCollidable.getMaxY());
                break;
        }
    }

    public void collisionDetection(Ruben ruben) {

        if (!currentCollidable.isCrashed()) {


            if (((ruben.getPlayerImage().getX() <= currentCollidable.getMinX() && currentCollidable.getMinX() <= ruben.getPlayerImage().getMaxX()) ||
                    (ruben.getPlayerImage().getX() <= currentCollidable.getMaxX() && currentCollidable.getMaxX() <= ruben.getPlayerImage().getMaxX())) &&
                    (ruben.getPlayerImage().getY() >= currentCollidable.getMinY() && currentCollidable.getMinY() <= ruben.getPlayerImage().getMaxY()) ||
                    (ruben.getPlayerImage().getY() >= currentCollidable.getMaxY() && currentCollidable.getMaxY() <= ruben.getPlayerImage().getMaxY())) {


                System.out.println("collision detected");
                System.out.println(ruben.getMaxX());
                System.out.println(currentCollidable.getMinX());
                currentCollidable.getCollidablePicture().delete();



                if (currentCollidable instanceof Beers) {

                    System.out.println("crashed a beer");
                    ruben.setSobriety(ruben.getSobriety() - 1);


                }


                if (currentCollidable instanceof Birds) {

                    System.out.println("crashed a bird");
                    ruben.setHealth(ruben.getHealth() - 1);

                }


                if (ruben.getHealth() == 0 || ruben.getSobriety() == 0) {
                    ruben.setDead(true);
                }

                generateCurrentCollidable();

            }

        }
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






