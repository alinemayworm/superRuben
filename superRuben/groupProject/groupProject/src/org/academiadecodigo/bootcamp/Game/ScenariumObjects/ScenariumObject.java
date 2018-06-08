package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Movable;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class ScenariumObject implements Movable {

    private int initialX;
    private int initialY;

    public Picture pic;
    private Field grid;
    private Rectangle rec;


    public void move(){

    }

    public Rectangle getRec(){
        return rec;
    }

}