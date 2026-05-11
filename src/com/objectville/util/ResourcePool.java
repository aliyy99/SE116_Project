package com.objectville.util;

import com.objectville.model.Cell;
import com.objectville.model.Commercial;
import com.objectville.model.Housing;
import com.objectville.model.Industrial;
import com.objectville.simulation.Grid;
import com.objectville.model.Zones;

public class ResourcePool {
    private static int totalPopulation;
    private static int totalGoods;
    private static int totalLifestyle;



    public  int getTotalPopulation() {
        return totalPopulation;
    }

    public int getTotalGoods() {
        return totalGoods;
    }

    public int getTotalLifestyle() {
        return totalLifestyle;
      }
    public static void addPopulation(int amount){
        totalPopulation = totalPopulation + amount;
    }
    public static void addGoods(int amount){
        totalGoods = totalGoods + amount;
    }
    public static void addLifestyle(int amount){
        totalLifestyle = totalLifestyle + amount;
    }
    public static void reset(){
        totalLifestyle = 0;
        totalGoods = 0;
        totalPopulation = 0;
    }

    public static void distributeResource(Grid grid){
        int industrialCount = 0;
        int commercialCount = 0;
        int housingCount = 0;
        for(Cell[] cell : grid.getCells()){
            for(Cell cell2: cell){
                if(cell2 instanceof Housing) housingCount++;
                else if(cell2 instanceof Commercial) commercialCount++;
                else if(cell2 instanceof Industrial) industrialCount++;
            }

        }
        int populationPerZone = 0;
        int goodsPerZone = 0;
        int lifestylePerZone = 0;
        if(industrialCount+commercialCount>0){
            populationPerZone = totalPopulation/(industrialCount+commercialCount);
        }
        if(commercialCount>0){
            goodsPerZone = totalGoods/commercialCount;
        }
        if(housingCount>0){
            lifestylePerZone = totalLifestyle/housingCount;
        }
        for(Cell[] cell : grid.getCells()){
            for(Cell cell2 : cell){
                if(cell2 instanceof Housing){
                    ((Housing) cell2).setReceivedLifestyle(lifestylePerZone);

                }
                else if(cell2 instanceof Commercial){
                    ((Commercial) cell2).setReceivedGoods(goodsPerZone);
                    ((Commercial) cell2).setReceivedPopulation(populationPerZone);
                }
                else if(cell2 instanceof Industrial){
                    ((Industrial) cell2).setReceivedPopulation(populationPerZone);
                }
            }
        }
        reset();
    }

}
