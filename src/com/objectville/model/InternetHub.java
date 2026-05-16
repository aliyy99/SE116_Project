package com.objectville.model;

public class InternetHub extends UtilityProvider{
    private String resourceType;
    public InternetHub(int row,int col){
        super(row, col);
        this.resourceType = "Internet";
    }

    public String getResourceType() {
        return resourceType;
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
