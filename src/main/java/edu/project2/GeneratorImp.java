package edu.project2;

import edu.project2.interfaces.Generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImp implements Generator {

    private static final List<Coordinate> DELTAS = List.of(
        new Coordinate(-2, 0),
        new Coordinate(2, 0),
        new Coordinate(0, 2),
        new Coordinate(0, -2)
    );
    private static final Random RANDOM = new Random();

    public Maze generate(int height, int width, Coordinate start, Coordinate end) {
        var maze = generate(height, width);
        var grid = maze.getGrid();
        grid[start.row()][start.col()] = new Cell(start.row(), start.col(), Cell.Type.PASSAGE);
        grid[end.row()][end.col()] = new Cell(end.row(), end.col(), Cell.Type.PASSAGE);
        return new Maze(grid);
    }

    @SuppressWarnings({"MagicNumber", "CyclomaticComplexity"})
    @Override
    public Maze generate(int height, int width) {
        var grid = new Cell[height][width];
        for (var row = 0; row < height; row++) {
            for (var col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        int col = RANDOM.nextInt(width / 2) * 2 + 1;
        int row = RANDOM.nextInt(height / 2) * 2 + 1;
        grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);

        var toCheck = new ArrayList<Coordinate>();
        if (row - 2 >= 0) {
            toCheck.add(new Coordinate(row - 2, col));
        }

        if (row + 2 < height) {
            toCheck.add(new Coordinate(row + 2, col));
        }

        if (col - 2 >= 0) {
            toCheck.add(new Coordinate(row, col - 2));
        }

        if (col + 2 < width) {
            toCheck.add(new Coordinate(row, col + 2));
        }

        while (!toCheck.isEmpty()) {
            int index = RANDOM.nextInt(0, toCheck.size());
            Coordinate coord = toCheck.get(index);
            row = coord.row();
            col = coord.col();
            grid[row][col] = new Cell(row, col, Cell.Type.PASSAGE);
            toCheck.remove(index);
            while (true) {
                int dirIndex = RANDOM.nextInt(0, DELTAS.size());
                if (DELTAS.get(dirIndex).equals(new Coordinate(-2, 0))) {
                    if (row - 2 >= 0
                        && grid[row - 2][col].type() == Cell.Type.PASSAGE) {
                        grid[row - 1][col] = new Cell(row - 1, col, Cell.Type.PASSAGE);
                        break;
                    }
                }

                if (DELTAS.get(dirIndex).equals(new Coordinate(2, 0))) {
                    if (row + 2 < height
                        && grid[row + 2][col].type() == Cell.Type.PASSAGE) {
                        grid[row + 1][col] = new Cell(row + 1, col, Cell.Type.PASSAGE);
                        break;
                    }
                }

                if (DELTAS.get(dirIndex).equals(new Coordinate(0, -2))) {
                    if (col - 2 >= 0
                        && grid[row][col - 2].type() == Cell.Type.PASSAGE) {
                        grid[row][col - 1] = new Cell(row, col - 1, Cell.Type.PASSAGE);
                        break;
                    }
                }

                if (DELTAS.get(dirIndex).equals(new Coordinate(0, 2))) {
                    if (col + 2 < width
                        && grid[row][col + 2].type() == Cell.Type.PASSAGE) {
                        grid[row][col + 1] = new Cell(row, col + 1, Cell.Type.PASSAGE);
                        break;
                    }
                }
            }

            if (row - 2 >= 0 && grid[row - 2][col].type() == Cell.Type.WALL) {
                toCheck.add(new Coordinate(row - 2, col));
            }
            if (row + 2 < height && grid[row + 2][col].type() == Cell.Type.WALL) {
                toCheck.add(new Coordinate(row + 2, col));
            }
            if (col - 2 >= 0 && grid[row][col - 2].type() == Cell.Type.WALL) {
                toCheck.add(new Coordinate(row, col - 2));
            }
            if (col + 2 < width && grid[row][col + 2].type() == Cell.Type.WALL) {
                toCheck.add(new Coordinate(row, col + 2));
            }
        }

        return new Maze(grid);
    }
}
