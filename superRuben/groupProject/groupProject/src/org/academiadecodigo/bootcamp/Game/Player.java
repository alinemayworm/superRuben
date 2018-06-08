package org.academiadecodigo.bootcamp.Game;
public class Player implements Movable {

    private boolean isJumping;
    private boolean isDown;
    private boolean isDead;

    private int health;
    private int sobriety;
    private Field field;




    @Override
    public void move() {
        System.out.println("move");
    }
}
