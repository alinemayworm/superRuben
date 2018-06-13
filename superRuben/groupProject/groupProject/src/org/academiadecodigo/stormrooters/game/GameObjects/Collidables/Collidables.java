package org.academiadecodigo.stormrooters.game.GameObjects.Collidables;

import org.academiadecodigo.stormrooters.game.GameObjects.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Collidables implements Movable {

    private boolean current;
    private Picture collidablePicture;


    private boolean crashed;

    protected final int initX;

    public Collidables(int initX) {
        this.initX = initX;
    }


    public void reset() {
        collidablePicture.translate(initX - collidablePicture.getX(), 0);
        crashed = false;
        current = true;
        collidablePicture.draw();
    }

    @Override
    public void move() {
        if (collidablePicture.getX() <= -60) {
            current = false;
        }
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isCurrent() {
        return current;
    }

    public double getMaxX() {
        return collidablePicture.getMaxX();
    }

    public double getMaxY() {
        return collidablePicture.getMaxY();
    }

    public double getMinY() {
        return collidablePicture.getY();
    }

    public double getMinX() {
        return collidablePicture.getX();
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
