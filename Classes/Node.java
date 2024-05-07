package Classes;

import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Node> neighbors;

    public Node(String name) {

        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public String getName() {
        return name;
    }
    
    public Node[] getNeighbors() {
        return neighbors.toArray(new Node[neighbors.size()]);
    }
}
