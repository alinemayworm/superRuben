package org.academiadecodigo.stormrooters.game.GameObjects.Collidables;

import org.academiadecodigo.stormrooters.game.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Beer extends Collidables {

    private Picture beerImage = new Picture(610, 485, "/beer1.png");
    private Field grid;

    public Beer(Field grid) {
        super(610);
        this.grid = grid;
        beerImage.draw();
        setCollidablePicture(beerImage);

    }

    @Override
    public void move() {

        if (isCurrent()) {
            beerImage.delete();
            beerImage.translate(-15, 0);
            setCollidablePicture(beerImage);
            beerImage.draw();
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        }

        super.move();
    }

    @Override
    public void reset() {
        super.setCollidablePicture(beerImage);
        super.reset();
    }
}
