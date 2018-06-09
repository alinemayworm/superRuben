package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int PADDING = 10;
    private Rectangle field;
    private ScorePanel scorePanel;
    private Rectangle road;
    private Rectangle fieldBorder;

    /**
     * Creates new field;
     */
    public Field() {

        field = new Rectangle(PADDING, PADDING, 720 , 600);
        field.fill();
        field.setColor(Color.CYAN);


        fieldBorder = new Rectangle(0,0,PADDING,610);
        fieldBorder.setColor(Color.WHITE);

        scorePanel = new ScorePanel();
        scorePanel.show();

        road = new Rectangle(10,490,600,120);
        road.fill();
        road.setColor(Color.GRAY);

    }

    /**
     *
     * @return
     */
    public ScorePanel getScorePanel(){
        return scorePanel;
    }

    public Rectangle getfieldBorder(){
        return fieldBorder;
    }

}
