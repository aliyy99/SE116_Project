package com.objectville.model;

public abstract class Cell {
    protected int row,col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public abstract String getSymbol();
    public abstract void update();
    public abstract void accumulate();

}
