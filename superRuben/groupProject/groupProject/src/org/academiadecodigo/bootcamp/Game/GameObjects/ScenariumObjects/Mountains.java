package org.academiadecodigo.bootcamp.Game.GameObjects.ScenariumObjects;
import org.academiadecodigo.bootcamp.Game.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mountains extends ScenariumObject{

    private Field field;
    private Picture mountainImage;
    int x = 0;
    int y = 0;

    public Mountains(int x, int y, Field field, int number) {

        this.field = field;

        x = x;
        y = y;

        field.getScorePanel().hide();

            switch(number) {
                case 1:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 1-.png");
                    break;
                case 2:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 2-.png");
                    break;
                case 3:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 3-.png");
                    break;
                case 4:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 4-.png");
                    break;

                case 5:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 5-.png");
                    break;

                case 6:
                    this.mountainImage = new Picture(10 + x, 10 + y, "/montanha 6-.png");
                    break;
            }

        this.mountainImage.draw();
        field.getScorePanel().show();
    }


    @Override
    public void move() {

        this.mountainImage.translate(-20, 0);
        field.getfieldBorder().delete();
        field.getfieldBorder().fill();
        field.getScorePanel().hide();
        field.getScorePanel().show();


        if (this.mountainImage.getX() <= -120) {

            this.mountainImage.delete();
            this.mountainImage.translate(720, 0);
            this.mountainImage.draw();
            field.getScorePanel().hide();
            field.getScorePanel().show();

        }

    }


    public void show(){

        this.mountainImage.delete();
        this.mountainImage.draw();

    }

}


