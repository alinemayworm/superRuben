package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.Game.Movable;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public abstract class ScenariumObject implements Movable {

    private int col;
    private int row;
    private Grid grid;
    private GridPosition pos;
    private Rectangle rec;

    public abstract void move();

    public Rectangle getRec() {
        return rec;
    }

    public GridPosition getGridPosition() {
        return pos;
    }

    public GridPosition makeGridPosition(int col, int row, Grid grid){
        return grid.makeGridPosition(col,row);

    }



    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }
}
