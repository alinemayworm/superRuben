package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class ScorePanel {

    private Picture scorePanel;
    private Rectangle healthDisplay;
    private Rectangle sobrietyDisplay;




    public ScorePanel() {
        scorePanel = new Picture(610, 10, "/SCOREPANEL.jpg");

        scorePanel.draw();

        healthDisplay = new Rectangle(625, 77, 90, 5);
        healthDisplay.setColor(Color.GREEN);
        healthDisplay.fill();

        sobrietyDisplay = new Rectangle(625, 127, 90, 5);
        sobrietyDisplay.setColor(Color.ORANGE);
        sobrietyDisplay.fill();

    }

    public void show() {

        scorePanel.draw();
        healthDisplay.fill();
        sobrietyDisplay.fill();
    }

    public void hide() {
        scorePanel.delete();
        healthDisplay.delete();
        sobrietyDisplay.delete();
    }

    public Rectangle getHealthDisplay() {
        return healthDisplay;
    }

    public Rectangle getSobrietyDisplay() {
        return sobrietyDisplay;
    }
}
