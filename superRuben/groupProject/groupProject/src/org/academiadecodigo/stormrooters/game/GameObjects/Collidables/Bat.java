package org.academiadecodigo.stormrooters.game.GameObjects.Collidables;

import org.academiadecodigo.stormrooters.game.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bat extends Collidables {

    private Picture birdImage;

    private Field grid;

    Picture flyOne = new Picture(610, 360, "/bat1.png");
    Picture flyTwo = new Picture(610, 360, "/bat2.png");


    public Bat(Field grid) {
        super(610);
        this.grid = grid;

        birdImage = flyOne;
        setCollidablePicture(flyOne);
        birdImage.draw();

    }

    public void move() {

        if (!isCurrent()) {
            return;
        }

        super.move();

        if (birdImage == flyOne) {
            birdImage.delete();
            birdImage = flyTwo;
            birdImage.draw();
            birdImage.translate(-30, 0);
            setCollidablePicture(birdImage);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
            return;
        }


        birdImage.delete();
        birdImage = flyOne;
        birdImage.draw();
        birdImage.translate(-30, 0);
        setCollidablePicture(birdImage);
        grid.getfieldBorder().delete();
        grid.getfieldBorder().fill();
        grid.getScorePanel().hide();
        grid.getScorePanel().show();
    }

    @Override
    public void reset() {
        setCollidablePicture(flyTwo);
        super.reset();
        flyTwo.delete();
        setCollidablePicture(flyOne);
        super.reset();
    }
}



