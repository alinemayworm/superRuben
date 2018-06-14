package org.academiadecodigo.stormrooters.game;

import org.academiadecodigo.stormrooters.game.GameObjects.Collidables.Beer;
import org.academiadecodigo.stormrooters.game.GameObjects.Collidables.Bat;
import org.academiadecodigo.stormrooters.game.GameObjects.Collidables.Collidables;
import org.academiadecodigo.stormrooters.game.GameObjects.Player.Ruben;
import org.academiadecodigo.stormrooters.game.GameObjects.ScenariumObjects.Clouds;
import org.academiadecodigo.stormrooters.game.GameObjects.ScenariumObjects.Mountains;
import org.academiadecodigo.stormrooters.game.GameObjects.ScenariumObjects.RoadStripes;
import org.academiadecodigo.stormrooters.game.GameObjects.ScenariumObjects.ScenariumObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Field grid = new Field();

    private Picture bannerStart = new Picture(10, 10, "/banner start.png");
    private Picture bannerInstructions = new Picture(10, 10, "/banner instructions.png");
    private Picture vampire = new Picture(10, 10, "/backgroundVampire.png");
    private Picture drunk = new Picture(10, 10, "/backgroundBeer.jpg");
    private Picture bannerFase2 = new Picture(10, 10, "/bannerFase2.png");
    private Picture bannerFase3 = new Picture(10, 10, "/bannerFase3.png");
    private Picture nightSky = new Picture(10, 10, "/nightsky.png");
    private Picture daySky = new Picture(10, 10, "/bgsky.jpg");
    private Picture gameWin = new Picture(10, 10, "/gameWin.png");
    private Sound music = new Sound("/BossMain.wav");
    private Sound vampireSound = new Sound("/Evil Laugh.wav");
    private Sound beerSound = new Sound("/beerSound.wav");
    private Sound endSound = new Sound("/fim.wav");


    private int delay = 75;
    private int countObjects = 0;

    private Ruben ruben = new Ruben(grid);

    private boolean gameOn = false;

    private Collidables currentCollidable;
    private Collidables bat = new Bat(grid);
    private Collidables beer = new Beer(grid);

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


    private GameKeyboard keyboard = new GameKeyboard(ruben, this);


    public void init() {

        grid.getScorePanel().show();
        keyboard.controls();
        generateCurrentCollidable();
        grid.getScorePanel().hide();
        grid.getScorePanel().show();


    }


    public void start() {

        init();

        bannerStart.draw();
        pause(4000);
        bannerStart.delete();

        while (true) {

            bannerInstructions.draw();
            System.out.println(gameOn);

            if (gameOn) {

                bannerInstructions.delete();

                music.loopIndef();
                music.play(true);

                while (!ruben.isDead() && countObjects <= 12) {

                    pause(delay);
                    moveAll();
                }


                if (!ruben.isDead()) {

                    music.stop();
                    startFase(50, nightSky);
                    bannerFase2.draw();
                    pause(5000);
                    bannerFase2.delete();
                    music.loopIndef();
                    music.play(true);

                }

                while (!ruben.isDead() && countObjects <= 28) {

                    pause(delay);
                    moveAll();
                }

                if (!ruben.isDead()) {

                    music.stop();
                    startFase(25, daySky);
                    bannerFase3.draw();
                    pause(5000);
                    bannerFase3.delete();
                    music.loopIndef();
                    music.play(true);


                }

                while (!ruben.isDead() && countObjects <= 48) {

                    pause(delay);
                    moveAll();
                }

                if (!ruben.isDead()) {
                    music.stop();
                    endSound.play(true);
                    gameWin.draw();
                    pause(5000);
                    endSound.stop();
                    gameWin.delete();

                }

                gameOn = false;
                resetGame();

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
                this.currentCollidable = beer;
                break;

            case 1:
                this.currentCollidable = bat;
                break;
        }


        currentCollidable.reset();
        grid.getScorePanel().hide();
        grid.getScorePanel().show();

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


                if (currentCollidable instanceof Beer) {
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
                            break;

                    }

                    if (ruben.getSobriety() == 0) {
                        beerSound.play(true);
                        lose(drunk);
                        gameOn = false;
                        return;
                    }


                    return;
                }


                if (currentCollidable instanceof Bat) {
                    generateCurrentCollidable();
                    ruben.setHealth(ruben.getHealth() - 1);

                    switch (ruben.getHealth()) {

                        case 2:
                            grid.getScorePanel().hide();
                            grid.getScorePanel().getHealthDisplay().grow(0, -16);

                            grid.getScorePanel().getHealthDisplay().translate(0, 16);
                            grid.getScorePanel().show();
                            break;

                        case 1:
                            grid.getScorePanel().hide();
                            grid.getScorePanel().getHealthDisplay().grow(0, -16);
                            grid.getScorePanel().getHealthDisplay().translate(0, 16);
                            grid.getScorePanel().show();
                            break;

                        case 0:
                            grid.getScorePanel().getHealthEllipse().delete();
                            break;

                    }

                    if (ruben.getHealth() == 0) {

                        vampireSound.play(true);
                        lose(vampire);
                        gameOn = false;
                        return;
                    }


                }

            }

        }

    }


    private void lose(Picture picture) {
        ruben.setDead(true);
        picture.draw();
        pause(3000);
        setGameOn(false);
        picture.delete();
    }

    public void startFase(int delay, Picture picture) {

        this.delay = delay;
        ruben.setSobriety(3);
        ruben.setHealth(3);
        grid.getScorePanel().hide();
        grid.getScorePanel().reset();
        grid.getScorePanel().show();
        grid.getField().delete();
        grid.setField(picture);
        grid.getField().draw();
        grid.getRoad().delete();
        grid.getRoad().fill();

        for (ScenariumObject s : objects) {
            s.show();
        }

    }

    public void resetGame() {

        countObjects = 0;
        ruben.setDead(false);
        startFase(75, daySky);
        gameOn = false;

    }


    public void setGameOn(boolean on) {
        this.gameOn = on;
    }

}






