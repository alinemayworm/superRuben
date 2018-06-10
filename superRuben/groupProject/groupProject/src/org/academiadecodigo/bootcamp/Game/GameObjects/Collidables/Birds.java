package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Birds extends Collidables {

    private Picture birdImage = new Picture(610, 360, "/Users/codecadet/Desktop/Game images/bat1.png");

    private Field grid;

    Picture flyOne = new Picture(610, 360, "/Users/codecadet/Desktop/Game images/bat1.png");
    Picture flyTwo = new Picture(610, 360, "/Users/codecadet/Desktop/Game images/bat2.png");


    public Birds(Field grid) {
        this.grid = grid;

        setCollidablePicture(birdImage);
        birdImage.draw();
        setPosition();

    }

    public void move() {

        if (isCurrent()) {

            if (birdImage == flyOne) {
                birdImage.delete();
                birdImage = flyTwo;
                birdImage.draw();
                birdImage.translate(-30, 0);
                setCollidablePicture(birdImage);
                setPosition();
                grid.getfieldBorder().delete();
                grid.getfieldBorder().fill();
                grid.getScorePanel().hide();
                grid.getScorePanel().show();
                return;
            }



            birdImage.delete();
            birdImage = flyOne;
            setPosition();
            birdImage.draw();
            birdImage.translate(-30, 0);
            setCollidablePicture(birdImage);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

            if (birdImage.getX() <= -60) {
                double j = birdImage.getX();
                birdImage.delete();
                birdImage.translate(610 - j, 0);
                setCollidablePicture(birdImage);
                setPosition();
                birdImage.draw();
                grid.getScorePanel().hide();
                grid.getScorePanel().show();
                setCurrent(false);

            }


        }

    }

    public void setPosition() {
        super.setPosition(birdImage.getX(), birdImage.getY(), birdImage.getMaxX(), birdImage.getMaxY());

    }

}



