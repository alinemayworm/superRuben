package org.academiadecodigo.bootcamp.Game.GameObjects.Collidables;

import org.academiadecodigo.bootcamp.Game.GameObjects.Movable;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Collidables implements Movable{

    private boolean current;

    @Override
    public void move() {

    }

    public void setCurrent(boolean current){
        this.current = current;
    }

    public boolean isCurrent() {
        return current;
    }
}
