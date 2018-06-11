package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Clouds extends ScenariumObject {

    private Picture cloudImage;
    private Field grid;

    public Clouds(int x, int y, Field grid) {

        this.grid = grid;

        cloudImage = new Picture (10 + x, 10 + y, "/cloud 1.png");
        cloudImage.draw();
    }

    @Override
    public void move() {

            this.cloudImage.translate(-5, 0);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        if (this.cloudImage.getX() <= -120) {

            this.cloudImage.delete();
            this.cloudImage.translate(720, 0);
            this.cloudImage.draw();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
        }
    }
}
