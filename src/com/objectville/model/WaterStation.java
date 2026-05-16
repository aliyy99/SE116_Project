package com.objectville.model;

public class WaterStation extends UtilityProvider{
    private String resourceType;
    public WaterStation(int row,int col){
        super(row, col);
        this.resourceType = "Water";
    }

    public String getResourceType() {
        return resourceType;
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
