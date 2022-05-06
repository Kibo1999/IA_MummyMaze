package searchmethods;

import agent.State;
import java.util.List;

public class AStarSearch extends InformedSearch {

    //f = g + h
    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for (State s:successors) {
            double g = parent.getG() + s.getAction().getCost();
            double h = heuristic.compute(s);

            if (explored.contains(s)){
                continue;
            }

            if (frontier.containsState(s) && frontier.getNode(s).getG() > g){
                frontier.removeNode(s);
            }


            Node node = new Node(s,parent,g, g+h);
            frontier.add(node);
        }
    }

    @Override
    public String toString() {
        return "A* search";
    }
}
