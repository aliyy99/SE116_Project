package com.objectville.model;

public class PowerPlant extends UtilityProvider{
    private String resourceType;
    public PowerPlant(int row,int col){
        super(row, col);
        this.resourceType = "Electricity";
    }

    public String getResourceType() {
        return resourceType;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public void update() {

    }

    @Override
    public void accumulate() {

    }
}
