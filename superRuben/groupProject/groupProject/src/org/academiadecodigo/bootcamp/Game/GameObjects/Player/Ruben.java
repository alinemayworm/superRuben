package org.academiadecodigo.bootcamp.Game.GameObjects.Player;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.bootcamp.Game.GameObjects.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ruben implements Movable {

    private boolean jumping;
    private boolean down;
    private boolean dead;

    private int count = 0;
    private int health;
    private int sobriety;
    private Field field;

    private Rectangle playerImage;


    public Ruben(int x, int y, Field field) {

        this.field = field;

        field.getScorePanel().hide();

        this.playerImage = new Rectangle(10 + x, 10 + y, 60, 120);
        this.playerImage.fill();
        this.playerImage.setColor(Color.MAGENTA);

        field.getScorePanel().hide();
    }


    public void jump() {

        if(count < 3) {
            this.playerImage.delete();
            this.playerImage.translate(0, -20);
            this.playerImage.fill();
            count++;
           return;
        }

        this.playerImage.delete();
        this.playerImage.translate(0, 20);
        this.playerImage.fill();
        count++;


        if(count >= 6 ){
            count = 0;
            setJumping(false);
        }


    }


    @Override
    public void move() {

        if (jumping) {
            jump();
            setJumping(false);

        } else {
            walk();

        }
    }

    public void walk() {

        if (playerImage.getColor() == Color.PINK) {
            playerImage.delete();
            playerImage.setColor(Color.MAGENTA);
            playerImage.fill();
            return;
        }
        playerImage.delete();
        playerImage.setColor(Color.PINK);
        playerImage.fill();
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

    public void pause() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
