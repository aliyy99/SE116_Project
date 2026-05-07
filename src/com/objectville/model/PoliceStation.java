package com.objectville.model;

public class PoliceStation extends ServiceBuilding{
    public PoliceStation(int row,int col){
        super(row, col, 5);
    }

    @Override
    public String getSymbol() {
        return "F";
    }

    @Override
    public void accumulate() {

    }

    @Override
    public void update() {

    }

    @Override
    public String getServiceType() {
        return "Security";
    }
}
