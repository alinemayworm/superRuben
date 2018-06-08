package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Mountains extends ScenariumObject {

    private int initialX;
    private int initialY;

    private Field grid;
    private Rectangle mountainImage;


    public Mountains(int x, int y, Field grid) {
        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        this.mountainImage = new Rectangle(10 + x, 10 + y, 120, 240);
        this.mountainImage.fill();
        this.mountainImage.setColor(Color.GREEN);
    }

    @Override
    public void move() {

        if (this.mountainImage.getX() > -120) {
            this.mountainImage.translate(-10, 0);
                grid.getGridBorder().delete();
                grid.getGridBorder().fill();
            }

            this.mountainImage.delete();
            this.mountainImage.translate(720, 0);
            this.mountainImage.fill();
            grid.getScorePanel().delete();
            grid.getScorePanel().fill();
        }


        public void pause () {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


