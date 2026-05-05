package com.objectville.model;

public class InternetHub extends UtilityProvider{
    protected String resourceType;
    public InternetHub(int row,int col){
        super(row, col);
        this.resourceType = "Internet";
    }
    @Override
    public String getSymbol(){
        return "T";
    }

    @Override
    public void update() {

    }

    @Override
    public void accumulate() {

    }
}
