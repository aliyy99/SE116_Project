package com.objectville.model;

public class PowerPlant extends UtilityProvider{
    protected String resourceType;
    public PowerPlant(int row,int col){
        super(row, col);
        this.resourceType = "Electricity";
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
