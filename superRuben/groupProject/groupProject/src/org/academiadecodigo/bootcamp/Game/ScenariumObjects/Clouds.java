package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Clouds extends ScenariumObject {

    private Rectangle cloudImage;
    private Field grid;

    private int initialX;
    private int initialY;


    public Clouds(int x, int y, Field grid) {
        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        cloudImage = new Rectangle(10 + x, 10 + y, 120, 60);
        cloudImage.fill();
        cloudImage.setColor(Color.WHITE);
    }

    @Override
    public void move() {

            this.cloudImage.translate(-10, 0);
            grid.getGridBorder().delete();
            grid.getGridBorder().fill();

        if (this.cloudImage.getX() <= -120) {

            this.cloudImage.delete();
            this.cloudImage.translate(720, 0);
            this.cloudImage.fill();
            grid.getScorePanel().delete();
            grid.getScorePanel().fill();
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
