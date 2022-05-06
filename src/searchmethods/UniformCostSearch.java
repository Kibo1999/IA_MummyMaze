package searchmethods;

import agent.State;
import java.util.List;
import utils.NodePriorityQueue;

public class UniformCostSearch extends GraphSearch<NodePriorityQueue> {

    public UniformCostSearch(){
        frontier = new NodePriorityQueue();
    }

    // f = g
    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {

        for (State s:successors) {
            double g = parent.getG() + s.getAction().getCost();

            if (explored.contains(s)){
                continue;
            }

            if (frontier.containsState(s) && frontier.getNode(s).getG() > g){
                frontier.removeNode(s);
            }

            Node node = new Node(s,parent, g, g);
            frontier.add(node);
        }


    }

    @Override
    public String toString() {
        return "Uniform cost search";
    }
}
