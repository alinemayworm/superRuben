package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Beers;
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Birds;
import org.academiadecodigo.bootcamp.Game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.bootcamp.Game.GameObjects.Player.Ruben;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.RoadStripes;
import org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects.ScenariumObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Field grid = new Field();

    private Picture vampire = new Picture(10, 10, "/backgroundVampire.png");
    private Picture bannerFase2 = new Picture(10, 10, "/banner.png");

    private GameKeyboard keyboard;

    private int delay = 100;

    private int countObjects = 0;

    private Ruben ruben;

    private boolean gameOn = false;

    private Collidables currentCollidable;

    private Collidables bird = new Birds(grid);
    private Collidables beer = new Beers(grid);

    public void init() {

        grid.getScorePanel().show();
        ruben = new Ruben(grid);
        keyboard = new GameKeyboard(ruben, this);
        keyboard.controls();
        generateCurrentCollidable();
        grid.getScorePanel().hide();
        grid.getScorePanel().show();
        bannerFase2.draw();

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
            System.out.println(gameOn);

            if(gameOn){
                bannerFase2.delete();

                while (!ruben.isDead() && countObjects <= 6) {

                    pause(delay);
                    moveAll();
                }


                bannerFase2.draw();
                pause(2000);

                this.delay = 50;
                ruben.setSobriety(3);
                ruben.setHealth(3);
                grid.getScorePanel().reset();
                grid.getScorePanel().hide();
                grid.getScorePanel().show();

                bannerFase2.delete();

                while (!ruben.isDead() && countObjects <= 20) {
                    pause(delay);
                    moveAll();
                }
            }

        }

    }


    public void pause(int delay) {

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


        if (currentCollidable.isCurrent()) {
            currentCollidable.move();

        } else {

            generateCurrentCollidable();
        }

        ruben.move();

        collisionDetection(ruben);

    }

    public void generateCurrentCollidable() {

        int random = (int) (Math.random() * 2);

        switch (random) {
            case 0:
                this.currentCollidable = new Beers(grid);
                currentCollidable.setCollidablePicture(beer.getCollidablePicture());
                currentCollidable.setCurrent(true);
                currentCollidable.setCrashed(false);
                currentCollidable.getCollidablePicture().draw();
                currentCollidable.setPosition(currentCollidable.getMinX(), currentCollidable.getMinY(), currentCollidable.getMaxX(), currentCollidable.getMaxY());
                grid.getScorePanel().hide();
                grid.getScorePanel().show();
                break;

            case 1:
                this.currentCollidable = new Birds(grid);
                currentCollidable.setCollidablePicture(bird.getCollidablePicture());
                currentCollidable.setCurrent(true);
                currentCollidable.setCrashed(false);
                currentCollidable.getCollidablePicture().draw();
                currentCollidable.setPosition(currentCollidable.getMinX(), currentCollidable.getMinY(), currentCollidable.getMaxX(), currentCollidable.getMaxY());
                grid.getScorePanel().hide();
                grid.getScorePanel().show();
                break;

        }

        countObjects++;

    }

    public void collisionDetection(Ruben ruben) {

        double rubenMinX = ruben.getMinX();
        double rubenMaxX = ruben.getMaxX();
        double rubenMinY = ruben.getMinY();
        double rubenMaxY = ruben.getMaxY();

        double currentMinX = currentCollidable.getMinX();
        double currentMaxX = currentCollidable.getMaxX();
        double currentMinY = currentCollidable.getMinY();
        double currentMaxY = currentCollidable.getMaxY();


        if (!currentCollidable.isCrashed()) {


            if (((rubenMinX <= currentMinX && currentMinX <= rubenMaxX) ||
                    rubenMinX <= currentMaxX && currentMaxX <= rubenMaxX) &&

                    ((rubenMinY <= currentMinY && currentMinY <= rubenMaxY) ||
                            (rubenMinY <= currentMaxY && currentMaxY <= rubenMaxY))) {


                currentCollidable.getCollidablePicture().delete();
                ruben.blink();

                System.out.println(countObjects);


                if (currentCollidable instanceof Beers) {
                    generateCurrentCollidable();
                    ruben.setSobriety(ruben.getSobriety() - 1);

                    switch (ruben.getSobriety()) {

                        case 2:
                            grid.getScorePanel().getSobrietyDisplay().grow(0, -16);
                            grid.getScorePanel().getSobrietyDisplay().translate(0, 16);
                            break;

                        case 1:
                            grid.getScorePanel().getSobrietyDisplay().grow(0, -16);
                            grid.getScorePanel().getSobrietyDisplay().translate(0, 16);

                            break;

                        case 0:
                            grid.getScorePanel().getSobrietyEllipse().delete();

                    }


                    if (ruben.getSobriety() == 0) {
                        ruben.setDead(true);
                        return;
                    }

                    System.out.println("ruben sobriety is now " + ruben.getSobriety());
                    return;
                }


                if (currentCollidable instanceof Birds) {
                    generateCurrentCollidable();
                    ruben.setHealth(ruben.getHealth() - 1);
                    switch (ruben.getSobriety()) {

                        case 2:
                            grid.getScorePanel().getHealthDisplay().grow(0, -15);
                            grid.getScorePanel().getHealthDisplay().translate(0, 15);
                            break;

                        case 1:
                            grid.getScorePanel().getHealthDisplay().grow(0, -15);
                            grid.getScorePanel().getHealthDisplay().translate(0, 15);

                            break;

                        case 0:
                            grid.getScorePanel().getHealthEllipse().delete();

                    }

                    if (ruben.getHealth() == 0) {
                        ruben.setDead(true);
                        vampire.draw();


                        return;
                    }

                    System.out.println("ruben health is now " + ruben.getHealth());


                }


            }


        }

    }


    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean on) {
        this.gameOn = on;
    }

}






