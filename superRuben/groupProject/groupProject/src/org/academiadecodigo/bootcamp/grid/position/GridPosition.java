package org.academiadecodigo.bootcamp.grid.position;

import org.academiadecodigo.bootcamp.grid.Grid;

/**
 * Base skeleton for a grid position
 *
 * @see GridPosition
 */
public class GridPosition{

    private int col;
    private int row;
    private Grid grid;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */
    public GridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * @see GridPosition#setPos(int, int)
     */

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * @see GridPosition#getCol()
     */

    public int getCol() {
        return col;
    }

    /**
     * @see GridPosition#getRow()
     */

    public int getRow() {
        return row;
    }



    /**
     * @see GridPosition#equals(GridPosition)
     */

    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }

    /**
     * Moves the position up
     *
     * @param dist the number of positions to move
     */

    public void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());

    }


    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

}
