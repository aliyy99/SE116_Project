package com.objectville.model;

public abstract class UtilityProvider extends Cell{
    protected final int capacity;
    protected int remainingCapacity;
    public UtilityProvider(int row,int col){
        super(row, col);
        this.capacity = 100;
    }
    public  int getCapacity(){
        return capacity;
    }


}
