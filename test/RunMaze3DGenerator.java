package algorithms.test;

import algorithms.maze3D.*;
import algorithms.mazeGenerators.*;
import algorithms.search.*;

import java.util.ArrayList;

public class RunMaze3DGenerator {
    public static void main(String[] args) throws Exception {
        testMazeGenerator(new MyMaze3DGenerator());
    }
    private static void testMazeGenerator(MyMaze3DGenerator mazeGenerator) throws Exception {
        // prints the time it takes the algorithm to run
        System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(100,/*depth*/100/*rows*/,100/*columns*/)));
        // generate another maze
        Maze3D maze = mazeGenerator.generate(100,/*depth*/100/*rows*/,100/*columns*/);
        // prints the maze
        maze.print();
        // get the maze entrance
        Position3D startPosition = maze.getStartPosition();
        // print the start position
        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
        // prints the maze exit position
        System.out.println(String.format("Goal Position: %s", maze.getGoalPosition()));
    }
}
