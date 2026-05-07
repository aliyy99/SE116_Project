package com.objectville.util;

import com.objectville.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapParser {
    public static Cell[][] parseMap(String filePath){
        List <String> lines = new ArrayList<>();

    try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
        String line;
        while((line = br.readLine()) != null){
            lines.add(line);
        }

    }catch (IOException e){
        e.printStackTrace();
    }
        if (lines.isEmpty()) return null;//Because IO does not control whether the text file is empty.

    int rows = lines.size();
    int cols = lines.get(0).length();
    Cell[][] grid = new Cell[rows][cols];

        for (int r = 0; r < rows; r++) {
            String line = lines.get(r);
        for (int c = 0; c < cols; c++){
            char cType = (c < line.length()) ? line.charAt(c) : 'E';//f the line is shorter than expected or empty,a security check will be performed.

        switch (cType) {
            case 'H':
            grid[r][c] = new Housing(r, c);
            break;
            case 'R':
                grid[r][c] = new Road(r, c);
                break;
            case 'I':
                grid[r][c] = new Industrial(r, c);
                break;
            case 'C':
                grid[r][c] = new Commercial(r, c);
                break;
            case 'P':
                grid[r][c] = new PowerPlant(r, c);
                break;
            case 'W':
                grid[r][c] = new WaterStation(r, c);
                break;
            case 'T':
                grid[r][c] = new InternetHub(r, c);
                break;
            case 'F':
                grid[r][c] = new PoliceStation(r, c);
                break;
            case 'D':
                grid[r][c] = new Hospital(r, c);
                break;
            case 'S':
                grid[r][c] = new School(r, c);
                break;
            default:
                grid[r][c] = new EmptyCells(r, c);
                break;
        }
        }}
    return grid;
    }

}
