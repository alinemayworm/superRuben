package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class ScorePanel {

    private Rectangle scorePanel;
    private Field field;
    private Rectangle health;
    private Rectangle sobriety;


    public ScorePanel(Field field) {
        this.field = field;
        scorePanel = new Rectangle(610, 10, 120, 600);
        scorePanel.setColor(Color.RED);
        scorePanel.fill();

        health = new Rectangle(620, 40, 100, 20);
        health.setColor(Color.CYAN);
        health.fill();

        sobriety = new Rectangle(620, 100, 100, 20);
        sobriety.setColor(Color.YELLOW);
        sobriety.fill();
    }

    public void show() {
        scorePanel.fill();
        health.fill();
        sobriety.fill();
    }

    public void hide() {
        scorePanel.delete();
        health.delete();
        sobriety.delete();
    }

}
