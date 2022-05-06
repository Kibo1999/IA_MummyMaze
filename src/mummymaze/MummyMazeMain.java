package mummymaze;

import showSolution.SolutionPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MummyMazeMain {
    private static String FILE_PATH = "./nivel";

    public static void main(String[] args) throws IOException {
        // read the initial state from a file
        MummyMazeState state = MummyMazeAgent.readInitialStateFromFile(new File(FILE_PATH));
        // instantiate a new Agent
        MummyMazeAgent agent = new MummyMazeAgent(state);
        // instanciar um novo Problem
        MummyMazeProblem problem = new MummyMazeProblem(state);
        // execute the search algorithm to find a solution
        agent.solveProblem(problem);
        // execute the solution (which will generate a list of strings -- the turns)
        agent.executeSolution();
        // get the list of turns and the cost
        List<String> turns = agent.getTurns();
        double cost = agent.getSolutionCost();
        // show the list of turns in the GUI
        SolutionPanel.showSolution(turns, cost);
    }
}
