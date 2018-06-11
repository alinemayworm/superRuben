package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.GameObjects.Movable;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.midi.Receiver;

public abstract class Collidables implements Movable {

    private boolean current;
    private Picture collidablePicture = new Picture(610, 360, "/bat1.png");


    private double minX = collidablePicture.getX();
    private double maxX = collidablePicture.getMaxX();
    private double minY = collidablePicture.getY();
    private double maxY = collidablePicture.getMaxY();

    private boolean crashed;

    public void setPosition(double minX, double minY, double maxX, double maxY) {

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

    }

    @Override
    public void move() {

    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isCurrent() {
        return current;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinY() {
        return minY;
    }

    public double getMinX() {
        return minX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setCollidablePicture(Picture collidablePicture) {
        this.collidablePicture = collidablePicture;
    }

    public Picture getCollidablePicture() {
        return collidablePicture;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public boolean isCrashed() {
        return crashed;
    }
}
