package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Clouds extends ScenariumObject {

    private Rectangle cloudImage;
    private Field grid;

    public Clouds(int x, int y, Field grid) {

        this.grid = grid;

        cloudImage = new Rectangle(10 + x, 10 + y, 120, 60);
        cloudImage.setColor(Color.WHITE);
        cloudImage.fill();
    }

    @Override
    public void move() {

            this.cloudImage.translate(-10, 0);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        if (this.cloudImage.getX() <= -120) {

            this.cloudImage.delete();
            this.cloudImage.translate(720, 0);
            this.cloudImage.fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
        }
    }
}
