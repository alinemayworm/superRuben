package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Beers extends Collidables {

    private Rectangle beerImage;
    private Field grid;

    public Beers(int x, int y, Field grid) {
        this.grid = grid;

        beerImage = new Rectangle(10 + x, 10 + y, 60, 60);
        beerImage.setColor(Color.ORANGE);
        beerImage.fill();
    }

    @Override
    public void move() {


        this.beerImage.translate(-20,0);
        this.beerImage.delete();
        this.beerImage.fill();


        if (beerImage.getX() <= -60){
            beerImage.translate(700,0);
        }

    }


    public Rectangle getBeerImage() {
        return beerImage;
    }
}
