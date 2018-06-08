package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Mountains extends ScenariumObject {

    private int initialX;
    private int initialY;

    private Field field;
    private Rectangle mountainImage;


    public Mountains(int x, int y, Field field) {
        this.field = field;


        this.initialX = x;
        this.initialY = y;

        field.getScorePanel().delete();

        this.mountainImage = new Rectangle(10 + x, 10 + y, 120, 240);
        this.mountainImage.draw();
        this.mountainImage.setColor(Color.GREEN);

        field.getScorePanel().fill();
    }

    @Override
    public void move() {

        this.mountainImage.translate(-10, 0);
        field.getfieldBorder().delete();
        field.getfieldBorder().fill();

        if (this.mountainImage.getX() <= -120) {

            this.mountainImage.delete();
            this.mountainImage.translate(720, 0);
            this.mountainImage.draw();
            field.getScorePanel().delete();
            field.getScorePanel().fill();

        }

    }


    public void pause() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


