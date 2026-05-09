package com.objectville.util;

//We used euclid method
public class DistanceCalculator {
   public static double calculateEuclidDistance(int x1,int x2,int y1,int y2){
      return  Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));


    }
    public static boolean isWithinRange(int sourceX,int sourceY,int targetX,int targetY,int radius){
      double distance = calculateEuclidDistance(sourceX,sourceY,targetX,targetY);
      return distance <= radius;
    }

}
