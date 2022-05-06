package agent;

import eightpuzzle.EightPuzzleState;

import java.util.LinkedList;
import java.util.List;

public abstract class Problem <S extends State>{

    //TODO
    protected S initialState;
    protected Heuristic heuristic;
    protected List<Action> actions; //ações possiveis válidas e inválidas

    public abstract LinkedList<S> executeAction(S state);

    public abstract boolean isGoal(S state);

    public double computePathCost(LinkedList<Action> actions){
        double cost = 0.0;

        for (Action action:actions) {
            cost += action.getCost();
        }

        return cost;
    }

    public S getInitialState() {
        return initialState;
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    public Problem(List<Action> actions, S initialState) {
        this.actions = actions;
        this.initialState = initialState;
    }
}
