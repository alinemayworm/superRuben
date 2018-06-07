package org.academiadecodigo.bootcamp.Game.Collidables;

import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Beers extends Collidables {

    private Rectangle beerImage;
    private SimpleGfxGrid grid;

    private int initialX;
    private int initialY;


    public Beers(int x, int y, SimpleGfxGrid grid) {
        this.grid = grid;


        this.initialX = x;
        this.initialY = y;

        beerImage = new Rectangle(10 + x, 10 + y, 60, 60);
        beerImage.fill();
        beerImage.setColor(Color.ORANGE);
    }

    @Override
    public void move() {

        System.out.println("move");
    }
}
