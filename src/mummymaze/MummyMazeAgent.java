package mummymaze;

import agent.Agent;

import java.io.File;
import java.util.List;

public class MummyMazeAgent extends Agent<MummyMazeState> {


    public MummyMazeAgent(MummyMazeState environment) {
        super(environment);
    }

    public static MummyMazeState readInitialStateFromFile(File file) {
        return null;
    }

    public List<String> getTurns() {
        return null;
    }

    public double getSolutionCost() {
        return 0;
    }
}
