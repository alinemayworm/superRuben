package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Birds extends Collidables {

    private Rectangle birdImage;
    private Field grid;
    private boolean crashed;
    private boolean moving;


    public Birds(int x, int y, Field grid) {
        this.grid = grid;

        birdImage = new Rectangle(10 + x, 10 + y, 60, 60);
        birdImage.fill();
        birdImage.setColor(Color.BLUE);
    }

    public void move() {

        if (!crashed && moving) {
            birdImage.translate(-15, 0);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();

        }

        if (birdImage.getX() <= 60) {
            birdImage.delete();
            birdImage.translate(660, 0);
            birdImage.fill();
            moving = false;

        }

    }
}
