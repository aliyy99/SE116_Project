package com.objectville.model;

public abstract class Zones extends Cell{
    protected int level;
    protected boolean hasEducation;
    protected boolean hasSecurity;
    protected boolean hasHealth;
    protected int electricty,water,internet;
    protected int receivedGoods,receivedLifeStyle,receivedPopulation;
    protected boolean totalLoss;

    public Zones(int row, int col){
        super(row,col);
        this.level=0;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHasEducation() {
        return hasEducation;
    }

    public boolean isHasSecurity() {
        return hasSecurity;
    }

    public boolean isHasHealth() {
        return hasHealth;
    }

    public int getElectricty() {
        return electricty;
    }

    public int getWater() {
        return water;
    }

    public int getInternet() {
        return internet;
    }
    public void levelUp(){
        if(0<=level && level<3){
            level++;
        }
    }
    public void levelDown(boolean totalLoss){
        if(totalLoss){
            level=0;
        }
        else if(0<level && level<=3){
            level--;
        }
    }
    public int calculateMinUtility(){
        int min1_utility=Math.min(electricty,water);
        int min2_utility=Math.min(min1_utility,internet);
        return min2_utility;
    }
    public abstract void getOutput();

}
