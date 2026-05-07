package com.objectville.model;

public class Hospital extends ServiceBuilding{
    public Hospital(int row,int col){
        super(row,col,3);

    }
    @Override
    public String getSymbol(){
        return "D";
    }

    @Override
    public void update() {
        super.update(); //that will be research
    }

    @Override
    public void accumulate() {

    }

    @Override
    public String getServiceType() {
        return "Health";
    }
}
