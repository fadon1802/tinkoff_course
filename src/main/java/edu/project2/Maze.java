package edu.project2;

public final class Maze {
    private final Integer height;
    private final Integer width;
    private final Cell[][] grid;

    public Maze(Cell[][] grid){
        this.grid = grid;
        height = grid.length;
        width = grid[0].length;
    }
}
