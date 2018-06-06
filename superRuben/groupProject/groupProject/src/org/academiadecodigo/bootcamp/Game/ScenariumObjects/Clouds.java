package org.academiadecodigo.bootcamp.Game.ScenariumObjects;

import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Clouds extends ScenariumObject {

    private Rectangle cloudImage;
    private SimpleGfxGrid grid;
    private GridPosition pos;
    private int initialCol;
    private int initialRow;


    public Clouds(int col, int row, SimpleGfxGrid grid) {
        this.grid = grid;
        this.pos = makeGridPosition(col, row, grid);

        this.initialCol = col;
        this.initialRow = row;

        cloudImage = new Rectangle(10 + grid.columnToX(col), 10 + grid.rowToY(row), 120, 60);
        cloudImage.fill();
        cloudImage.setColor(Color.WHITE);
    }

    public void move() {

        }



    public Rectangle getCloudImage() {
        return cloudImage;
    }
}
