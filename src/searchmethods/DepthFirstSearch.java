package searchmethods;

import agent.Problem;
import agent.Solution;
import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class DepthFirstSearch extends GraphSearch<NodeLinkedList> {

    public DepthFirstSearch() {
        frontier = new NodeLinkedList();
    }

    //Graph Search without explored list
    @Override
    protected Solution graphSearch(Problem problem) {
        Node node = new Node(problem.getInitialState());
        frontier.clear();
        frontier.add(node);

        while(!frontier.isEmpty() && !stopped){
            Node frontierNode = frontier.remove();

            if (problem.isGoal(frontierNode.getState())){
                return new Solution(problem, frontierNode);
            }

            List<State> successors = problem.executeAction(frontierNode.getState());

            addSuccessorsToFrontier(successors, frontierNode);
            computeStatistics(successors.size());
        }

        return null;
    }

    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for (State s:successors) {
            if (frontier.containsState(s)){
                continue;
            }

            if(parent.isCycle(s)){
                continue;
            }

            Node node = new Node(s,parent);
            frontier.addFirst(node);

        }
    }

    @Override
    public String toString() {
        return "Depth first search";
    }
}
