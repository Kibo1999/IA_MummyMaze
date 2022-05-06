package searchmethods;

import agent.State;
import java.util.List;
import utils.NodePriorityQueue;

public class BeamSearch extends AStarSearch {

    private int beamSize;

    public BeamSearch() {
        this(100);
    }

    public BeamSearch(int beamSize) {
        this.beamSize = beamSize;
    }

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

            if (frontier.size() > beamSize){
                NodePriorityQueue aux = new NodePriorityQueue();
                
                for (int i = 0; i < beamSize; i++) {
                    aux.add(frontier.remove());
                }

                frontier = aux;
            }
        }

    }

    public void setBeamSize(int beamSize) {
        this.beamSize = beamSize;
    }

    public int getBeamSize() {
        return beamSize;
    }

    @Override
    public String toString() {
        return "Beam search";
    }
}
