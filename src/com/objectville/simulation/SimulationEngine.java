package com.objectville.simulation;

import com.objectville.model.*;
import com.objectville.util.*;

import static com.objectville.util.DistanceCalculator.isWithinRange;

public class SimulationEngine {
    private Grid grid;
    private int currentTick;

    public SimulationEngine(Grid grid) {
        this.grid = grid;
        this.currentTick = 0;
    }
    public void runSimulation(int tickCount) {
        for (int i = 0; i < tickCount; i++) {
            System.out.println("Tick " + (currentTick + 1));
            executeTick();
            currentTick++;
        }
    }
        private void executeTick() {
            resetTransientStates();
            executeStep1_Services();
            executeStep2_Utilities();

            if (currentTick > 1) {
                executeStep3_DistributeResources();
            }
            executeStep4_UpdateLevels();
            executeStep5_Accumulate();
        }

        private void resetTransientStates () {
            for (Cell[] row : grid.getCells()) {
                for (Cell cell : row) {
                    if (cell instanceof Zones) {
                        ((Zones) cell).resetTickData();
                    }
                }
            }
        }
        private void executeStep1_Services () {
            distributeEducation();
            distributeSecurity();
            distributeHealth();
        }
        private void distributeEducation() {
            scanAndApplyService(School.class);
    }
        private void distributeSecurity() {
            scanAndApplyService(PoliceStation.class);
    }
        private void distributeHealth() {
            scanAndApplyService(Hospital.class);
    }
    private void scanAndApplyService(Class<? extends ServiceBuilding> serviceClass) {
        Cell[][] map = grid.getCells();
        int rows = map.length;
        int cols = map[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (serviceClass.isInstance(map[r][c])) {

                    ServiceBuilding service = (ServiceBuilding) map[r][c];

                    int radius = service.getRadius();
                    String label = service.getServiceType();

                    for (int targetR = 0; targetR < rows; targetR++) {
                        for (int targetC = 0; targetC < cols; targetC++) {
                            Cell targetCell = map[targetR][targetC];

                            if (targetCell instanceof Zones) {

                                if (isWithinRange(r, c, targetR, targetC,radius)) {
                                    Zones zone = (Zones) targetCell;
                                    applyServiceFlag(zone, service.getServiceType());

                                    System.out.println(zone.getClass().getSimpleName() + " at ("+ targetR + "," + targetC +") received " + label);
                                }
                            }
                        }
                    }
                }
            }
        }}
        private void applyServiceFlag(Zones zone, String serviceLabel) {
            if (serviceLabel.equals("education service")) zone.setHasEducation(true);
            else if (serviceLabel.equals("security service")) zone.setHasSecurity(true);
            else if (serviceLabel.equals("health service")) zone.setHasHealth(true);
        }


        private void executeStep2_Utilities () {

    }

        private void executeStep3_DistributeResources () {
            ResourcePool.distributeResource(this.grid);
        }

    private void executeStep4_UpdateLevels() {
        for (Cell[] row : grid.getCells()) {
            for (Cell cell : row) {
                if (cell instanceof Zones) {
                    Zones zone = (Zones) cell;
                    int oldLevel = zone.getLevel();
                    zone.update();
                    int newLevel = zone.getLevel();
                    if (newLevel > oldLevel) {
                        System.out.println(zone.getClass().getSimpleName() + " at (" + zone.getRow() + "," + zone.getCol() + ") levels up from " + oldLevel + " to " + newLevel);
                    }
                    else{
                        System.out.println(zone.getClass().getSimpleName() + " at (" + zone.getRow() + "," + zone.getCol() + ") levels down from " + oldLevel + " to " + newLevel);
                    }
                }
            }
        }
    }


    private void executeStep5_Accumulate() {
        for(Cell[] row : grid.getCells()){
            for(Cell cell : row){
                if(cell instanceof Zones){
                    Zones zones = (Zones) cell;
                    cell.accumulate();
                    int producedAmount = ((Zones) cell).getOutput();
                    if(cell instanceof  Housing){
                        ResourcePool.addPopulation(producedAmount);
                        System.out.println( "House at(" +zones.getRow() + "," + zones.getCol() +") generated " + producedAmount + " population");
                    }
                    else if (cell instanceof Industrial) {
                        ResourcePool.addGoods(producedAmount);
                        System.out.println( "Industrial  at (" + zones.getRow() + "," + zones.getCol() + ") generated " + producedAmount + " goods");
                    }
                    else if (cell instanceof Commercial) {
                        ResourcePool.addLifestyle(producedAmount);
                        System.out.println( "Commercial at (" + zones.getRow() + "," + zones.getCol() + ") generated " + producedAmount + " lifestyle");

                    }

                }
            }
        }
    }

}

