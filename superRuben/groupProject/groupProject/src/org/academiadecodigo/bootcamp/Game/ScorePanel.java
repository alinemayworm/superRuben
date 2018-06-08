package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;



public class ScorePanel {

    private Rectangle scorePanel;
    private Field field;


    public ScorePanel(Field field){
        this.field = field;
        scorePanel = new Rectangle(610,10,120,600);
        scorePanel.setColor(Color.RED);
        scorePanel.fill();
    }

    public void show(){
        scorePanel.fill();
    }

    public void hide(){
        scorePanel.delete();
    }

}
