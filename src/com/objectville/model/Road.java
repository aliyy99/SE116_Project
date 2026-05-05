package com.objectville.model;

public class Road extends Cell {

    public Road(int row, int col) {
        super(row, col);
}

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public void update() {
        //The content should be left blank because the path has no level and will not change over time.
    }

    @Override
    public void accumulate() {
        //The content should be left blank because the road does not generate a resource.
    }

//BFS LOGİC HAS TO CREATE
}
