package com.objectville.model;

public class WaterStation extends UtilityProvider{
    protected String resourceType;
    public WaterStation(int row,int col){
        super(row, col);
        this.resourceType = "Water";
    }

    @Override
    public String getSymbol() {
        return "W";
    }

    @Override
    public void update() {

    }

    @Override
    public void accumulate() {

    }
}
