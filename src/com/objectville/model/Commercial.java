package com.objectville.model;

public class Commercial extends Zones {
    private int producedLifestyle;

    public Commercial(int row, int col) {
        super(row, col);
    }

    public int getProducedLifestyle() {
        return producedLifestyle;
    }

    @Override
    public int calculateMinUtility() {
        return Math.min(this.electricity, Math.min(this.water, this.internet));
    }

    @Override
    public int getOutput() {
        return producedLifestyle;
    }

    @Override
    public String getSymbol () {
        return "C";

    }

    @Override
    public void update() {
        boolean level_1=receivedPopulation>0 &&receivedGoods>0 && electricity>0 && water>0 && internet>0;
        boolean level_2=level_1 && hasSecurity;
        boolean level_3=level_2 && receivedGoods>0 && receivedPopulation>0;

        if (electricity == 0 && water == 0 && internet == 0){
            levelDown(true);
        }
        switch (level){
            case 0:
                if(level_1) levelUp();
                break;
            case 1:
                if(level_2) levelUp();
                else if(electricity==0 || water==0 || internet==0 || receivedPopulation==0 || receivedGoods==0) levelDown(false);
                break;

            case 2:
                if(level_3) levelUp();
                else if(!hasSecurity) levelDown(false);
                break;
            case 3:
                if(receivedPopulation==0 || receivedGoods==0) levelDown(false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
    }

    @Override
    public void accumulate() {
        int m = calculateMinUtility();

        switch(this.level){
            case 0 : this.producedLifestyle = 0;
                break;
            case 1 : this.producedLifestyle= m;
                break;
            case 2 : this.producedLifestyle = 2 * m;
                break;
            case 3 :
                int bottleneck = Math.min(receivedPopulation,receivedGoods);
                this.producedLifestyle = (2 * m) + bottleneck;
                break;
            default: this.producedLifestyle = 0;
        }
    }
}
