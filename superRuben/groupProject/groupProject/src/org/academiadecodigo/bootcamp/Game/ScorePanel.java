package org.academiadecodigo.bootcamp.Game;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class ScorePanel {

    private Picture scorePanel;
    private Rectangle healthDisplay;
    private Ellipse healthEllipse;
    private Rectangle sobrietyDisplay;
    private Ellipse sobrietyEllipse;




    public ScorePanel() {
        scorePanel = new Picture(610, 10, "/SCOREPANEL2.jpg");

        scorePanel.draw();

        healthDisplay = new Rectangle(666, 131, 5, 64);
        healthEllipse = new Ellipse(657,193,22,22);
        healthDisplay.setColor(Color.GREEN);
        healthDisplay.fill();
        healthEllipse.setColor(Color.GREEN);
        healthEllipse.fill();

        sobrietyDisplay = new Rectangle(666, 337 , 5, 64);
        sobrietyEllipse = new Ellipse(657,396,22,22);
        sobrietyDisplay.setColor(Color.YELLOW);
        sobrietyDisplay.fill();
        sobrietyEllipse.setColor(Color.YELLOW);
        sobrietyEllipse.fill();

    }

    public void show() {

        scorePanel.draw();
        healthDisplay.fill();
        healthEllipse.fill();
        sobrietyDisplay.fill();
        sobrietyEllipse.fill();
    }

    public void hide() {
        scorePanel.delete();
        healthEllipse.delete();
        healthDisplay.delete();
        sobrietyDisplay.delete();
        sobrietyEllipse.delete();
    }

    public Rectangle getHealthDisplay() {
        return healthDisplay;
    }

    public Rectangle getSobrietyDisplay() {
        return sobrietyDisplay;
    }

    public Ellipse getHealthEllipse() {
        return healthEllipse;
    }

    public Ellipse getSobrietyEllipse() {
        return sobrietyEllipse;
    }

    public void reset(){

        healthDisplay.delete();
        healthDisplay = new Rectangle(666, 131, 5, 64);
        healthDisplay.setColor(Color.GREEN);
        healthDisplay.fill();

        healthDisplay.delete();
        healthEllipse = new Ellipse(657,193,22,22);
        healthEllipse.setColor(Color.GREEN);
        healthEllipse.fill();

        healthDisplay.delete();
        sobrietyDisplay = new Rectangle(666, 337 , 5, 64);
        sobrietyDisplay.setColor(Color.YELLOW);
        sobrietyDisplay.fill();
        healthEllipse.delete();
        sobrietyEllipse = new Ellipse(657,396,22,22);
        sobrietyEllipse.setColor(Color.YELLOW);
        sobrietyEllipse.fill();


    }
}
