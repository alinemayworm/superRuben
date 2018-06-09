package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Birds extends Collidables {

    private Rectangle birdImage;
    private Field grid;
    private boolean crashed;



    public Birds(int x, int y, Field grid) {
        this.grid = grid;

        birdImage = new Rectangle(10 + x, 10 + y, 60, 60);
        birdImage.fill();
        birdImage.setColor(Color.BLUE);
    }

    public void move() {

        if (isCurrent()) {
            birdImage.delete();
            birdImage.translate(-30, 0);
            birdImage.fill();
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        }

        if (birdImage.getX() <= -60) {
            double i = birdImage.getX();
            birdImage.delete();
            birdImage.translate(-i + 610,0);
            birdImage.fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
            setCurrent(false);

        }

    }

}
