package edu.project2;

import edu.project2.interfaces.Solver;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolverImp implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        HashMap<Coordinate, Coordinate> previousMap = new HashMap<>();
        List<Coordinate> path = new ArrayList<>();

        var queue = new ArrayDeque<Coordinate>();
        queue.add(start);
        previousMap.put(start, null);
        while (!queue.isEmpty()) {
            var coord = queue.poll();
            if (coord.equals(end)) {
                while (coord != null) {
                    path.add(coord);
                    coord = previousMap.get(coord);
                }

                return path.reversed();
            }
            var neighbors = maze.getNeighbors(coord);
            for (var neighbor : neighbors) {
                if (!previousMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    previousMap.put(neighbor, coord);
                }
            }
        }

        return null;
    }
}
