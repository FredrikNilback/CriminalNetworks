package Classes;

import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Node> neighbors;
    private float weight;

    public Node(String name) {

        this.name = name;
        this.neighbors = new ArrayList<>();
        this.weight = 0;
    }

    public void addWeight(float change) {
        weight += change;
    }
    public float getWeight() {
        return weight;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }
    public Node[] getNeighbors() {
        return neighbors.toArray(new Node[neighbors.size()]);
    }

    public String getName() {
        return name;
    }
    
    
}
