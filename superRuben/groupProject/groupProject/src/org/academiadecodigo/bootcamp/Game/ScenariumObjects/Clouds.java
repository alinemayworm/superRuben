package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Clouds extends ScenariumObject {

    private Rectangle cloudImage;
    private SimpleGfxGrid grid;

    private int initialX;
    private int initialY;


    public Clouds(int x, int y, SimpleGfxGrid grid) {
        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        cloudImage = new Rectangle(10 + x, 10 + y, 120, 60);
        cloudImage.fill();
        cloudImage.setColor(Color.WHITE);
    }

@Override
    public void move() {

        while (this.cloudImage.getX() > -120) {
            this.cloudImage.translate(-10, 0);
            grid.getGridBorder().delete();
            grid.getGridBorder().fill();
            pause();
        }
        this.cloudImage.delete();
        this.cloudImage.translate(720, 0);
        this.cloudImage.fill();
        grid.getScorePanel().delete();
        grid.getScorePanel().fill();
    }
    public void pause() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
