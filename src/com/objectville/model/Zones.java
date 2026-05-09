package com.objectville.model;

public abstract class Zones extends Cell{
    protected int level;
    protected boolean hasEducation;
    protected boolean hasSecurity;
    protected boolean hasHealth;
    protected int electricity,water,internet;
    protected int receivedPopulation;
    protected int receivedGoods;
    protected int receivedLifestyle;

    public Zones(int row, int col){
        super(row,col);
        this.level=0;
    }
    public void resetTickData() {
        this.electricity = 0;
        this.water = 0;
        this.internet = 0;
        this.hasEducation = false;
        this.hasHealth = false;
        this.hasSecurity = false;
        this.receivedPopulation = 0;
        this.receivedGoods = 0;
        this.receivedLifestyle = 0;
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
        return electricity;
    }

    public int getWater() {
        return water;
    }

    public int getReceivedPopulation() {
        return receivedPopulation;
    }

    public void setReceivedPopulation(int receivedPopulation) {
        this.receivedPopulation = receivedPopulation;
    }

    public int getReceivedGoods() {
        return receivedGoods;
    }

    public void setReceivedGoods(int receivedGoods) {
        this.receivedGoods = receivedGoods;
    }

    public int getReceivedLifestyle() {
        return receivedLifestyle;
    }

    public void setReceivedLifestyle(int receivedLifestyle) {
        this.receivedLifestyle = receivedLifestyle;
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
    public abstract int calculateMinUtility();


    public abstract int getOutput();
}
