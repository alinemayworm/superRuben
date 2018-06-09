package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RoadStripes extends ScenariumObject {

    private Rectangle stripeImage;
    private Field grid;

    public RoadStripes (int x, int y, Field grid) {

        this.grid = grid;


        stripeImage = new Rectangle(10 + x, 10 + y, 30, 10);
        stripeImage.fill();
        stripeImage.setColor(Color.YELLOW);
    }

    @Override
    public void move() {
        System.out.println("move");

    }

}
