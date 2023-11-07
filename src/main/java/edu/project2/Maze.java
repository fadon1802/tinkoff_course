package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Maze {
    private static final List<Coordinate> DELTAS = List.of(
        new Coordinate(-1, 0),
        new Coordinate(1, 0),
        new Coordinate(0, 1),
        new Coordinate(0, -1)
    );
    private final Integer height;
    private final Integer width;
    private final Cell[][] grid;

    public Maze(Cell[][] grid) {
        this.grid = grid;
        height = grid.length;
        width = grid[0].length;
    }

    public static Cell[][] convertToCellGrid(int[][] grid) {
        var cellGrid = new Cell[grid.length][grid[0].length];
        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                cellGrid[row][col] = new Cell(row, col, Cell.Type.values()[grid[row][col]]);
            }
        }

        return cellGrid;
    }

    public Cell[][] getGrid() {
        return Arrays.copyOf(grid, grid.length);
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public Cell.Type getType(int row, int col) {
        return grid[row][col].type();
    }

    public List<Coordinate> getNeighbors(Coordinate coord) {
        var neighbors = new ArrayList<Coordinate>();
        for (var d : DELTAS) {
            var neighborCoord = new Coordinate(
                d.row() + coord.row(),
                d.col() + coord.col()
            );
            if (neighborCoord.row() < 0 || neighborCoord.row() >= height) {
                continue;
            }

            if (neighborCoord.col() < 0 || neighborCoord.col() >= width) {
                continue;
            }

            if (!isWall(neighborCoord)) {
                neighbors.add(neighborCoord);
            }
        }

        return neighbors;
    }

    private boolean isWall(Coordinate coord) {
        return grid[coord.row()][coord.col()].type() == Cell.Type.WALL;
    }
}
