package com.objectville.util;

import com.objectville.model.Cell;
import com.objectville.model.Road;
import com.objectville.model.UtilityProvider;
import com.objectville.model.Zones;
import com.objectville.simulation.Grid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSUtility {
    public static void distribute_utility(Grid grid, UtilityProvider provider,String resourceType){
        Queue<Cell> queue=new LinkedList<>();
        Set<Cell> visited=new HashSet<>();
        int remainingCapacity=provider.getCapacity();
        queue.add(provider);
        visited.add(provider);

        while(!queue.isEmpty() && remainingCapacity>0){
            Cell current= queue.poll();

            if(current instanceof Zones){
                Zones zone=(Zones) current;
                int demand=zone.getUtilityDemand(resourceType);
                int given=Math.min(demand,remainingCapacity);

                zone.receiveResource(resourceType,given);
                remainingCapacity-=given;
            }
            for(Cell neighbor:grid.getNeighbors(current.getRow(),current.getCol())){
                if(!visited.contains(neighbor) && isConnectable(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    private static boolean isConnectable(Cell cell){
        return cell instanceof Zones || cell instanceof Road;
    }
}
