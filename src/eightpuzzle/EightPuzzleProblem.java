package eightpuzzle;

import agent.Action;
import agent.Problem;
import agent.State;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EightPuzzleProblem extends Problem<EightPuzzleState> {

    private EightPuzzleState goalState;

    public EightPuzzleProblem(EightPuzzleState state) {
        super(new ArrayList<>(4), state);
        createAvailableActionsList(super.actions);

        this.goalState = new EightPuzzleState(EightPuzzleState.GOAL_MATRIX);
    }

    private void createAvailableActionsList(List<Action> actions) {
        actions.add(new ActionLeft());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionUp());
    }

    public EightPuzzleProblem(List<Action> actions, EightPuzzleState initialState) {
        super(actions, initialState);
    }

    @Override
    public LinkedList<EightPuzzleState> executeAction(EightPuzzleState state) {
        LinkedList<EightPuzzleState> successors = new LinkedList<>();
        for (Action a:actions) {
            if (a.isValid(state)){
                EightPuzzleState newState = (EightPuzzleState) state.clone();
                a.execute(newState);
                successors.add(newState);
            }
        }
        return successors;
    }

    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.equals(goalState);
    }

    //TODO


    public EightPuzzleState getGoalState() {
        return goalState;
    }

    @Override
    public double computePathCost(LinkedList<Action> actions) {
        return actions.size();
    }


}
