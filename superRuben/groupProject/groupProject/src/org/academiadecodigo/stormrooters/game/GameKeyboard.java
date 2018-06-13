package org.academiadecodigo.stormrooters.game;

import org.academiadecodigo.stormrooters.game.GameObjects.Player.Ruben;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class GameKeyboard implements KeyboardHandler {

    private Ruben ruben;
    private Game game;


    public GameKeyboard(Ruben ruben, Game game) {
        this.ruben = ruben;
        this.game = game;

    }

    public void controls() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent eventJump = new KeyboardEvent();
        eventJump.setKey(KeyboardEvent.KEY_UP);
        eventJump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventJump);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventDown);

        KeyboardEvent eventStart = new KeyboardEvent();
        eventStart.setKey(KeyboardEvent.KEY_SPACE);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventStart);

        KeyboardEvent eventQuit = new KeyboardEvent();
        eventQuit.setKey(KeyboardEvent.KEY_Q);
        eventQuit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(eventQuit);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                ruben.setJumping(true);
                break;

            case KeyboardEvent.KEY_DOWN:
                ruben.setDown(true);
                break;

            case KeyboardEvent.KEY_SPACE:
                game.setGameOn(true);
                break;

            case KeyboardEvent.KEY_Q:
                game.setRun(false);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
