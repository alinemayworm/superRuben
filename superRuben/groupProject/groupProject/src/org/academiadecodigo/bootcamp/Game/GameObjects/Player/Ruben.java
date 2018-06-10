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

    private int health = 3;
    private int sobriety = 3;

    private Field field;

    private Rectangle playerImage;


    public Ruben(int x, int y, Field field) {

        this.field = field;

        this.playerImage = new Rectangle(10 + x, 10 + y, 60, 120);
        this.playerImage.fill();
        this.playerImage.setColor(Color.MAGENTA);

    }


    public void jump() {

        if (count < 7) {
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


        if (count == 14) {
            count = 0;
            setJumping(false);
        }


    }


    @Override
    public void move() {

        if (jumping) {
            jump();

    } else

    {
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

    public Rectangle getPlayerImage() {
        return playerImage;
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
