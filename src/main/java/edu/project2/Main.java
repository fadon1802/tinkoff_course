package edu.project2;

import static java.lang.System.Logger.Level.INFO;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        var logger = System.getLogger("main");
        var solver = new SolverImp();
        var renderer = new RendererImp();
        var generator = new GeneratorImp();
        var generatedMaze = generator.generate(21, 21, new Coordinate(1, 0), new Coordinate(19, 20));
        var path = solver.solve(generatedMaze, new Coordinate(1, 0), new Coordinate(19, 20));
        logger.log(INFO, "\n" + renderer.render(generatedMaze, path));
    }
}

