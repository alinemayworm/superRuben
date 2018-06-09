package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Beers extends Collidables {

    private Rectangle beerImage;
    private Field grid;
    private boolean crashed;



    public Beers(int x, int y, Field grid) {
        this.grid = grid;
        crashed = false;
        beerImage = new Rectangle(10 + x, 10 + y, 60, 60);
        beerImage.setColor(Color.ORANGE);
        beerImage.fill();
    }

    @Override
    public void move() {

        if(isCurrent()) {
            beerImage.delete();
            beerImage.translate(-20, 0);
            beerImage.fill();
            grid.getfieldBorder().delete();
            grid.getfieldBorder().fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();

        }

        if(beerImage.getX() <= -60) {
            double i = beerImage.getX();
            beerImage.delete();
            beerImage.translate(-i + 610, 0);
            beerImage.fill();
            grid.getScorePanel().hide();
            grid.getScorePanel().show();
            setCurrent(false);

        }

    }

}
