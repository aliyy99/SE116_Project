package com.objectville.model;

public abstract class ServiceBuilding extends Cell {
     protected static int radius;
     public ServiceBuilding(int row,int col, int radius){
        super(row,col);
        this.radius = radius;
   }

    @Override
    public String getSymbol() {
        return "";
    }

    @Override
    public void update() {

    }

    @Override
    public void accumulate() {

    }
    public abstract String getServiceType();
     public int getRadius(){return radius;}
}
