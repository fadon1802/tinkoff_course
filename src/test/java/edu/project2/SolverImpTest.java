package edu.project2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverImpTest {

    @Test
    void canFindPath() {
        var solver = new SolverImp();
        var testMaze = new Maze(Maze.convertToCellGrid(Grids.GRID1));
        var path = solver.solve(
            testMaze,
            new Coordinate(0, 1),
            new Coordinate(5, 4)
        );
        assertNotNull(path);
    }

    @Test
    void correctRender() {
        var solver = new SolverImp();
        var renderer = new RendererImp();
        var testMaze = new Maze(Maze.convertToCellGrid(Grids.GRID1));
        assertEquals(
            """
                X X X X X X
                        X X
                X X   X   X
                X X   X   X
                X X       X
                X X X X   X
                """, renderer.render(testMaze));
    }

    @Test
    void correctRenderWithPath() {
        var solver = new SolverImp();
        var renderer = new RendererImp();
        var testMaze = new Maze(Maze.convertToCellGrid(Grids.GRID1));
        var path = solver.solve(
            testMaze,
            new Coordinate(0, 1),
            new Coordinate(5, 4)
        );
        assertEquals(
            """
                X X X X X X
                  * *   X X
                X X * X   X
                X X * X   X
                X X * * * X
                X X X X * X
                """, renderer.render(testMaze, path));
    }

    @Test
    void generateAndSolve() {
        var solver = new SolverImp();
        var generator = new GeneratorImp();
        var generatedMaze = generator.generate(21, 21, new Coordinate(1, 0), new Coordinate(19, 20));
        var check = solver.solve(generatedMaze, new Coordinate(1, 0), new Coordinate(19, 20));
        assertNotNull(check);
    }
}
