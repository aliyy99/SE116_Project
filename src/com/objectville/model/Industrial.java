package com.objectville.model;

import com.objectville.util.ResourcePool;

public class Industrial extends Zones{
    private int producedGoods;

    public Industrial(int row, int col) {
        super(row, col);
    }

    public int getProducedGoods() {
        return producedGoods;
    }

    @Override
    public int calculateMinUtility() {
        return Math.min(this.electricity, this.water);
    }

    @Override
    public int getOutput() {
        return producedGoods;
    }

    @Override
    public String getSymbol () {
        return "I";

    }

    @Override
    public void update() {
        boolean level_1=receivedPopulation>0 && electricity>0 && water>0;
        boolean level_2=level_1 && hasSecurity;
        boolean level_3=level_2 && receivedPopulation>0;

        if (electricity == 0 && water == 0){
            levelDown(true);
        }
        switch (level){
            case 0:
                if(level_1) levelUp();
                break;
            case 1:
                if(level_2) levelUp();
                else if(electricity==0 || water==0 || receivedPopulation==0) levelDown(false);
                break;
            case 2:
                if(level_3) levelUp();
                else if(!hasSecurity) levelDown(false);
                break;
            case 3:
                if(receivedPopulation==0) levelDown(false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
    }


    @Override
    public void accumulate() {
        int m = calculateMinUtility();

        switch(this.level){
            case 0 : this.producedGoods = 0;
                break;
            case 1 : this.producedGoods = m;
                break;
            case 2 : this.producedGoods = 2 * m;
                break;
            case 3 : this.producedGoods = (2 * m) + receivedPopulation;
                break;
            default: this.producedGoods = 0;
        }
        ResourcePool.addGoods(producedGoods);
    }
}

