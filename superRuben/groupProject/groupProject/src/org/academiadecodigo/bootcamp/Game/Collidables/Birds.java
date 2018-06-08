package org.academiadecodigo.bootcamp.Game.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Birds extends Collidables {

    private Rectangle birdImage;
    private Field grid;

    private int initialX;
    private int initialY;


    public Birds(int x, int y, Field grid) {
        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        birdImage = new Rectangle(10 + x, 10 + y, 60, 60);
        birdImage.fill();
        birdImage.setColor(Color.ORANGE);
    }

    @Override
    public void move() {

        System.out.println("move");
    }
}
