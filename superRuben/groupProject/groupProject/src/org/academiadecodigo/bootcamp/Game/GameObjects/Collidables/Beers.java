package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Beers extends Collidables {

    private Rectangle beerImage;
    private Field grid;
    private boolean crashed;
    private boolean moving;


    public Beers(int x, int y, Field grid) {
        this.grid = grid;
        crashed = false;
        beerImage = new Rectangle(10 + x, 10 + y, 60, 60);
        beerImage.setColor(Color.ORANGE);
        beerImage.fill();
    }

    @Override
    public void move() {

        if(!crashed && moving) {
            beerImage.translate(-15, 0);
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();

        }

        if(beerImage.getX() <= 60) {
            beerImage.delete();
            beerImage.translate(660, 0);
            beerImage.fill();
            moving = false;

        }

    }

}
