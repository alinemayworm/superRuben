package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RoadStripes extends ScenariumObject {


    private Field grid;
    int count = 0;

    Rectangle[] stripeImage = {


            new Rectangle(10 + 0, 10 + 535, 60, 10),
            new Rectangle(10 + 120, 10 + 535, 60, 10),
            new Rectangle(10 + 240, 10 + 535, 60, 10),
            new Rectangle(10 + 360, 10 + 535, 60, 10),
            new Rectangle(10 + 480, 10 + 535, 60, 10),
            new Rectangle(10 + 600, 10 + 535, 60, 10),

    };

    public RoadStripes(Field grid) {

        this.grid = grid;

        for (Rectangle r : stripeImage) {
            r.fill();
            r.setColor(Color.YELLOW);
        }
    }

    @Override
    public void move() {

        for (Rectangle r : stripeImage) {
            r.translate(-30, 0);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();


            if (r.getX() <= -60) {

                r.delete();
                r.translate(720, 0);
                r.fill();
                grid.getScorePanel().hide();
                grid.getScorePanel().show();


            }

        }

    }

    public void show(){
        for (Rectangle r : stripeImage){
            r.delete();
            r.fill();
        }
    }

}
