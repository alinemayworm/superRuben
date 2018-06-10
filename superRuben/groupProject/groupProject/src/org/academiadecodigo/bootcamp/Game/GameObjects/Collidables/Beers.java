package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Beers extends Collidables {

    private Picture beerImage = new Picture(610,465,"/Users/codecadet/Desktop/Game images/beer1.png");


    private Field grid;

    private int maxX = beerImage.getMaxX();
    private int maxY = beerImage.getMaxY();
    private int minX = beerImage.getX();
    private int minY = beerImage.getY();




    public Beers(Field grid) {
        this.grid = grid;
        beerImage.draw();
        setCollidablePicture(beerImage);
        setPosition();

    }

    @Override
    public void move() {

        if(isCurrent()) {
            beerImage.delete();
            beerImage.translate(-10, 0);
            setCollidablePicture(beerImage);
            setPosition();
            beerImage.draw();
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        }

        if(beerImage.getX() <= -60) {
            double i = beerImage.getX();
            beerImage.delete();
            beerImage.translate(-i + 610, 0);
            setPosition();
            setCollidablePicture(beerImage);
            beerImage.draw();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
            setCurrent(false);

        }


    }

    public void setPosition(){
        super.setPosition(beerImage.getX(),beerImage.getY(),beerImage.getMaxX(),beerImage.getMaxY());

    }


    @Override
    public void setMaxX(int maxX) {
        this.maxX = beerImage.getMaxX();
    }



}
