package com.objectville.model;

import com.objectville.util.ResourcePool;

public class Housing extends Zones {
    private int producedPopulation;
    public Housing(int row, int col) {
        super(row, col);
    }

    public int getProducedPopulation() {
        return producedPopulation;
    }

    @Override
    public int calculateMinUtility() {
        return Math.min(this.electricity, Math.min(this.water, this.internet));
    }

    @Override
    public int getOutput() {
        return producedPopulation;
    }

    @Override
    public String getSymbol () {
        return "H";

    }

    @Override
    public void update() {
        boolean level_1=electricity>0 && water>0 && internet>0;
        boolean level_2=level_1 && hasEducation && hasHealth && hasSecurity;
        boolean level_3=level_2 && receivedLifestyle>0;

        if (electricity == 0 && water == 0 && internet == 0){
            levelDown(true);
        }

        switch(level){
            case 0 :
                if (level_1)levelUp();
                break;
            case 1 :
                if (level_2)levelUp();
                else if (electricity == 0 || water == 0 || internet == 0)levelDown(false);
                break;
            case 2 :
                if (level_3)levelUp();
                else if (!hasEducation || !hasHealth || !hasSecurity)levelDown(false);
                break;
            case 3:
                if (receivedLifestyle == 0)levelDown(false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
    }

    @Override
    public void accumulate() {
        int m = calculateMinUtility();

        switch(this.level){
            case 0 : this.producedPopulation = 0;
            break;
            case 1 : this.producedPopulation = m;
            break;
            case 2 : this.producedPopulation = 2 * m;
            break;
            case 3 : this.producedPopulation = (2 * m) + receivedLifestyle;
            break;
            default: this.producedPopulation = 0;
        }
        ResourcePool.addPopulation(producedPopulation);
    }
}
