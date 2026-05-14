package com.objectville.simulation;

import com.objectville.model.*;
import com.objectville.util.*;

public class SimulationEngine {

        private Grid grid;

        public SimulationEngine(Grid grid) {
            this.grid = grid;
        }

    public void run(int ticks) {
        for (int currentTick = 1; currentTick <= ticks; currentTick++) {
            System.out.println("--- Tick " + currentTick + " Starting ---");

            resetTransientStates();

            executeStep1_Services();
            executeStep2_Utilities();

            if (currentTick > 1) {
                executeStep3_DistributeResources();
            }

            executeStep4_UpdateLevels();
            executeStep5_Accumulate();
        }
    }

    private void resetTransientStates() {
        for (Cell[] row : grid.getCells()) {
            for (Cell cell : row) {
                if (cell instanceof Zones) {
                    ((Zones) cell).resetTickData();
                }
            }
        }

    }

    private void executeStep1_Services() {

    }

    private void executeStep2_Utilities() {

    }

    private void executeStep3_DistributeResources() {
        ResourcePool.distributeResource(this.grid);
    }

    private void executeStep4_UpdateLevels() {
    }


    private void executeStep5_Accumulate() {
    }
}

