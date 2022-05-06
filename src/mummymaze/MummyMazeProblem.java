package mummymaze;

import agent.Action;
import agent.Problem;

import java.util.LinkedList;
import java.util.List;

public class MummyMazeProblem extends Problem<MummyMazeState> {


    public MummyMazeProblem(List<Action> actions, MummyMazeState initialState) {
        super(actions, initialState);
    }

    public MummyMazeProblem(MummyMazeState state) {
        super(state);
    }

    @Override
    public LinkedList<MummyMazeState> executeAction(MummyMazeState state) {
        return null;
    }

    @Override
    public boolean isGoal(MummyMazeState state) {
        return false;
    }
}
