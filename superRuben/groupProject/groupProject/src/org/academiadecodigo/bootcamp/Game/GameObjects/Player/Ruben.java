package org.academiadecodigo.bootcamp.Game.GameObjects.Player;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.bootcamp.Game.GameObjects.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ruben implements Movable {

    private boolean jumping;
    private boolean down;
    private boolean dead;

    private int countJumps = 0;
    private int countDown = 0;

    private int health = 3;
    private int sobriety = 3;

    private Field field;

    private Picture playerImage;

    private Picture walk1 = new Picture(70, 415, "/Users/codecadet/Desktop/Game images/walk1.png");
    private Picture walk2 = new Picture(70, 415, "/Users/codecadet/Desktop/Game images/walk2.png");
    private Picture walk3 = new Picture(70, 415, "/Users/codecadet/Desktop/Game images/walk3.png");
    private Picture walk4 = new Picture(70, 415, "/Users/codecadet/Desktop/Game images/walk4.png");

    private Picture walkDown = new Picture(70, 455, "/Users/codecadet/Desktop/Game images/down.png");


    public Ruben(Field field) {

        this.field = field;

        this.playerImage = walk1;
        this.playerImage.draw();

    }


    public void jump() {

        if (countJumps < 6) {
            this.playerImage.delete();
            this.playerImage.translate(0, -20);
            this.playerImage.draw();
            countJumps++;
            return;
        }

        this.playerImage.delete();
        this.playerImage.translate(0, 20);
        this.playerImage.draw();
        countJumps++;


        if (countJumps == 12) {
            countJumps = 0;
            setJumping(false);
        }


    }


    @Override
    public void move() {

        if (jumping) {
            jump();
            return;

        }

        if (down) {
            duck();
            return;
        }


        walk();

    }


    public void duck() {

        if (countDown <= 6) {
            this.playerImage.delete();
            this.playerImage = walkDown;
            this.playerImage.draw();
            countDown++;
            return;

        }
        this.playerImage.delete();
        this.playerImage = walk1;
        this.playerImage.draw();
        setDown(false);
        countDown = 0;
    }


    public void walk() {

        if (playerImage == walk1) {
            playerImage.delete();
            playerImage = walk2;
            playerImage.draw();
            return;
        }
        if (playerImage == walk2) {
            playerImage.delete();
            playerImage = walk3;
            playerImage.draw();
            return;
        }
        if (playerImage == walk3) {
            playerImage.delete();
            playerImage = walk4;
            playerImage.draw();
            return;
        }
        playerImage.delete();
        playerImage = walk1;
        playerImage.draw();

    }

    public void setJumping(boolean jump) {
        this.jumping = jump;

    }

    public boolean isJumping() {
        return jumping;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDown() {
        return down;
    }

}
