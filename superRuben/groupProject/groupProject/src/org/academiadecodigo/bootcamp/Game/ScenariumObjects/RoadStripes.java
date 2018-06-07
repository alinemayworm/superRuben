package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class RoadStripes extends ScenariumObject {

    private int initialX;
    private int initialY;

    private Rectangle stripeImage;
    private SimpleGfxGrid grid;

    public RoadStripes (int x, int y, SimpleGfxGrid grid) {

        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        stripeImage = new Rectangle(10 + x, 10 + y, 30, 10);
        stripeImage.fill();
        stripeImage.setColor(Color.YELLOW);
    }
    @Override
    public void move() {
        System.out.println("move");
    }
}
