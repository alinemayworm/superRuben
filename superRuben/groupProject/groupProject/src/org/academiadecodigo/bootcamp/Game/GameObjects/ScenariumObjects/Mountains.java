package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Mountains extends ScenariumObject{




    private Field field;
    private Rectangle mountainImage;


    public Mountains(int x, int y, Field field) {
        this.field = field;

        field.getScorePanel().hide();

        this.mountainImage = new Rectangle(10 + x, 10 + y, 120, 240);
        this.mountainImage.draw();
        this.mountainImage.setColor(Color.GREEN);

        field.getScorePanel().show();
    }

    @Override
    public void move() {
        field.getScorePanel().show();
        this.mountainImage.translate(-10, 0);
        field.getfieldBorder().delete();
        field.getfieldBorder().fill();


        if (this.mountainImage.getX() <= -120) {

            this.mountainImage.delete();
            this.mountainImage.translate(720, 0);
            this.mountainImage.draw();
            field.getScorePanel().hide();
            field.getScorePanel().show();

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


