package com.objectville.model;

public class Industrial extends Zones{
    protected int producedGoods;

    public Industrial(int row, int col) {
        super(row, col);

    }

    @Override
    public int calculateMinUtility() {
        return Math.min(this.electricity, this.water);
    }

    @Override
        public int getOutput() {
            return this.producedGoods;
        }

        @Override
        public String getSymbol () {
            return "I";

        }

    @Override
    public void update() {

    }


    @Override
        public void accumulate() {
//eklenecek
        }
    }

