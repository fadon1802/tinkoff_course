package edu.project2;

import edu.project2.interfaces.Renderer;
import java.util.List;

public class RendererImp implements Renderer {

    @Override
    public String render(Maze maze) {
        var sb = new StringBuilder();
        for (var row = 0; row < maze.height(); row++) {
            for (var col = 0; col < maze.width(); col++) {
                var type = maze.getType(row, col);
                switch(type) {
                    case Cell.Type.WALL:
                        sb.append("X");
                        break;
                    case Cell.Type.PASSAGE:
                        sb.append(" ");
                }

                if (col != maze.width() - 1){
                    sb.append(" ");
                } else {
                    sb.append("\n");
                }
            }
        }

        return sb.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        return null;
    }
}
