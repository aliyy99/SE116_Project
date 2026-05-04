package com.objectville.model;

public class Commercial extends Zones {
    private int producedLifestyle;

    public Commercial(int row, int col) {
        super(row, col);
    }

    @Override
    public int calculateMinUtility() {
        return Math.min(this.electricity, Math.min(this.water, this.internet));
    }

    @Override
        public int getOutput() {
            return this.producedLifestyle;
        }

        @Override
        public String getSymbol () {
            return "C";

        }

    @Override
    public void update() {
    }

        @Override
        public void accumulate() {
//eklenecek
        }
}
