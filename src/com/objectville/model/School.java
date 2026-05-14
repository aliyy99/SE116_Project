package com.objectville.model;

public class School extends ServiceBuilding{
    public School(int row,int col){
        super(row,col,4);
    }

    @Override
    public String getSymbol() {
        return "S";
    }

    @Override
    public void update() {

    }

    @Override
    public void accumulate() {

    }

    @Override
    public String getServiceType() {
        return "education service";
    }
}
