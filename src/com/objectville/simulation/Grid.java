package com.objectville.simulation;

import com.objectville.model.Cell;

import java.util.ArrayList;

public class Grid {
    private Cell[][] cells;
    private int rows,columns;

    public Grid( int rows, int columns) {
        this.cells = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public Cell[][] getCells() {
        return cells;
    }
    public Cell getCell(int r,int c){
        if(isValid(r,c)) return cells[r][c];
        return null;
    }
    public ArrayList<Cell> getNeighbors(int r,int c){
        ArrayList<Cell> neighbors=new ArrayList<>();
        for(int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if(i==0 && j==0) continue;
                int targetX=r+i;
                int targetY=c+j;

                if(isValid(targetX,targetY)){
                    neighbors.add(cells[targetX][targetY]);
                }
            }
        }
        return neighbors;
    }

    public boolean isValid(int r, int c){
        return r>=0 && r<rows && c>=0 && c<columns;
    }
}
