package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Birds extends Collidables {

    private Picture birdImage = new Picture(610, 380, "/Users/codecadet/Desktop/Game images/bat1.png");

    private int maxX = birdImage.getMaxX();
    private int maxY = birdImage.getMaxY();
    private int minX = birdImage.getX();
    private int minY = birdImage.getY();

    private Field grid;

    Picture flyOne = new Picture(610, 360, "/Users/codecadet/Desktop/Game images/bat1.png");
    Picture flyTwo = new Picture(610, 360, "/Users/codecadet/Desktop/Game images/bat2.png");
    //Picture flyThree = new Picture(610, 380, "/Users/codecadet/Desktop/Game images/bat3.png");
    //Picture flyFour = new Picture(610, 380, "/Users/codecadet/Desktop/Game images/bat4.png");


    public Birds(int x, int y, Field grid) {
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
                birdImage.translate(-20,0);
                setPosition();
                return;
            }

            /*if (birdImage == flyTwo) {
                birdImage.delete();
                birdImage = flyThree;
                birdImage.translate(-30,0);
                birdImage.draw();
                return;
            }

            if (birdImage == flyThree) {
                birdImage.delete();
                birdImage = flyFour;
                birdImage.translate(-30,0);
                birdImage.draw();
                return;
            }*/

            birdImage.delete();
            birdImage = flyOne;
            setPosition();
            birdImage.draw();
            birdImage.translate(-20,0);

            if (birdImage.getX() <= -60) {
                double i = birdImage.getX();
                birdImage.translate(-i + 610, 0);
                setPosition();
                grid.getScorePanel().hide();
                grid.getScorePanel().show();
                setCurrent(false);
            }
        }
    }

    public void setPosition(){
        super.setPosition(birdImage.getX(),birdImage.getY(),birdImage.getMaxX(),birdImage.getMaxY());

    }
}



