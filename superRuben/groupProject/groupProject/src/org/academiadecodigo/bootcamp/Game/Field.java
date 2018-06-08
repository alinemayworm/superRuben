package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int PADDING = 10;

    private Rectangle grid;

    private Rectangle scorePanel;
    private Rectangle road;

    private Rectangle gridBorder;


    public Field(int width, int height) {

        grid = new Rectangle(PADDING, PADDING, width , height);
        grid.fill();
        grid.setColor(Color.CYAN);

        scorePanel = new Rectangle(610,10,120,600);

        gridBorder = new Rectangle(0,0,10,610);
        gridBorder.setColor(Color.WHITE);

        scorePanel.fill();
        scorePanel.setColor(Color.RED);
        https://github.com/alinemayworm/superRuben.git
        road = new Rectangle(10,490,600,120);
        road.fill();
        road.setColor(Color.GRAY);

    }

    public int getX() {

        return grid.getX();
    }


    public int getY() {

        return grid.getY();
    }



    public int getPadding() {

        return PADDING;
    }

    public Rectangle getScorePanel(){
        return scorePanel;
    }

    public Rectangle getGridBorder(){
        return gridBorder;
    }

}
