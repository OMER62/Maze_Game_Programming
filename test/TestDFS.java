package algorithms.test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import java.util.ArrayList;
public class TestDFS {
    public static void main(String[] args) throws Exception {
        //Step A: Generate+ print the maze:
        AMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(10, 10);
        System.out.println("The maze:");
        maze.print();

        //Step B: adaptations the search algorithm for Maze object
        SearchableMaze searchableMaze = new SearchableMaze(maze);

        //Step C: Solved the Maze:
        ISearchingAlgorithm domain = new BestFirstSearch();
        long StartTime=System.currentTimeMillis();
        //we operate the generate method
        Solution solution = domain.solve(searchableMaze);
        //we save the end time of the method
        long EndTime=System.currentTimeMillis();
        System.out.println("The Path:");
        System.out.println(solution.getSolutionPath().toString());
        System.out.println("The Total vertex in the path:");
        System.out.println(solution.getTotalVertx());
        System.out.println("The Total time (in milliseconds):");
        System.out.println(EndTime-StartTime);

    }
}
