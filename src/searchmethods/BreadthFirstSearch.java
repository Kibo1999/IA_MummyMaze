package searchmethods;

import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class BreadthFirstSearch extends GraphSearch<NodeLinkedList> {

    public BreadthFirstSearch() {
        frontier = new NodeLinkedList();
    }

    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {

        for (State s:successors) {
            if (explored.contains(s) || frontier.containsState(s)){
                continue;
            }

            Node node = new Node(s,parent);
            frontier.addLast(node);

        }

    }

    @Override
    public String toString() {
        return "Breadth first search";
    }
}
