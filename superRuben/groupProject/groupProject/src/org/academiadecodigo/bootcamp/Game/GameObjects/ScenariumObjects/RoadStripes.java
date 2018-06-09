package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RoadStripes extends ScenariumObject {


    private Field grid;

    public RoadStripes (Field grid) {

        this.grid = grid;


        Rectangle[] stripeImage = {


                new Rectangle(10 + 60, 10 + 535, 60, 10),
                //new Rectangle(10 + 150, 10 + 535, 30, 10),
                new Rectangle(10 + 180, 10 + 535, 60, 10),
                //new Rectangle(10 + 270, 10 + 535, 30, 10),
                new Rectangle(10 + 300, 10 + 535, 60, 10),
                //new Rectangle(10 + 390, 10 + 535, 30, 10),
                new Rectangle(10 + 420, 10 + 535, 60, 10),
                //new Rectangle(10 + 510, 10 + 535, 30, 10),
                new Rectangle(10 + 540, 10 + 535, 60, 10),


        };

        for (Rectangle r : stripeImage) {
            r.fill();
            r.setColor(Color.YELLOW);
        }
    }

    @Override
    public void move() {
        System.out.println("move");

    }

}
