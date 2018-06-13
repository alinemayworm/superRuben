package org.academiadecodigo.stormrooters.game.GameObjects.ScenariumObjects;

import org.academiadecodigo.stormrooters.game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RoadStripes extends ScenariumObject {

    private final int PADDING = 10;

    private Field grid;

    Rectangle[] stripeImage = {

            new Rectangle(PADDING , PADDING + 535, 60, 10),
            new Rectangle(PADDING + 120, PADDING + 535, 60, 10),
            new Rectangle(PADDING + 240, PADDING + 535, 60, 10),
            new Rectangle(PADDING + 360, PADDING + 535, 60, 10),
            new Rectangle(PADDING + 480, PADDING + 535, 60, 10),
            new Rectangle(PADDING + 600, PADDING + 535, 60, 10),

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
