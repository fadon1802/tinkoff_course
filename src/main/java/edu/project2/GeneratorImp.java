package edu.project2;

import edu.project2.interfaces.Generator;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GeneratorImp implements Generator {

    private static final List<Coordinate> DELTAS = List.of(
        new Coordinate(-2, 0),
        new Coordinate(2, 0),
        new Coordinate(0, 2),
        new Coordinate(0, -2)
    );
    private static final Random randomizer = new Random();

    private final List<Coordinate> visited = new ArrayList<>();

    private List<Coordinate> getNeighbors(Coordinate current, int height, int width) {
        List<Coordinate> neighbors = new ArrayList<>();
        for (var d : DELTAS) {
            var neighborCoord = new Coordinate(
                d.row() + current.row(),
                d.col() + current.col()
            );
            if (neighborCoord.row() < 0 || neighborCoord.row() >= height) {
                continue;
            }

            if (neighborCoord.col() < 0 || neighborCoord.col() >= width) {
                continue;
            }

            if (!visited.contains(neighborCoord)) {
                neighbors.add(neighborCoord);
            }
        }

        return neighbors;
    }

    @Override
    public Maze generate(int height, int width) {
        var grid = new Cell[height][width];
        for (var row = 0; row < height; row++) {
            for (var col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        var current = new Coordinate(1, 0);
        visited.add(current);
        var stack = new Stack<Coordinate>();
        while (visited.size() != height * width) {
            var neighborsUnvisited = getNeighbors(current, height, width);
            if (!neighborsUnvisited.isEmpty()) {
                var pickNeighbor = neighborsUnvisited.get(randomizer.nextInt(neighborsUnvisited.size()));
                stack.addElement(pickNeighbor);
                var deleteWallRow = (pickNeighbor.row() + current.row()) / 2;
                var deleteWallCol = (pickNeighbor.col() + current.col()) / 2;
                grid[deleteWallRow][deleteWallCol] = new Cell(deleteWallRow, deleteWallCol, Cell.Type.PASSAGE);
                current = pickNeighbor;
                visited.add(pickNeighbor);
            } else {
                current = stack.pop();
            }
        }

        return new Maze(grid);
    }
}
