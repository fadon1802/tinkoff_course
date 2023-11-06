package edu.project2;

import java.util.Arrays;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        var solver = new SolverImp();
        var maze = new Maze(Maze.convertToCellGrid(Grids.grid));
        var path = solver.solve(
            maze,
            new Coordinate(0, 1),
            new Coordinate(5, 4));

        var renderer = new RendererImp();
        var generator = new GeneratorImp();
        var generatedMaze = generator.generate(3, 3);
        System.out.println(renderer.render(generatedMaze));
    }
}

