package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int PADDING = 10;

    private Rectangle field;

    private Rectangle scorePanel;
    private Rectangle road;

    private Rectangle fieldBorder;


    public Field(int width, int height) {

        field = new Rectangle(PADDING, PADDING, width , height);
        field.fill();
        field.setColor(Color.CYAN);

        scorePanel = new Rectangle(610,10,120,600);

        fieldBorder = new Rectangle(0,0,10,610);
        fieldBorder.setColor(Color.WHITE);

        scorePanel.fill();
        scorePanel.setColor(Color.RED);

        road = new Rectangle(10,490,600,120);
        road.fill();
        road.setColor(Color.GRAY);

    }

    public int getX() {

        return field.getX();
    }


    public int getY() {

        return field.getY();
    }



    public int getPadding() {

        return PADDING;
    }

    public Rectangle getScorePanel(){
        return scorePanel;
    }

    public Rectangle getfieldBorder(){
        return fieldBorder;
    }

}
