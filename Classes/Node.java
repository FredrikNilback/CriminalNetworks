package Classes;

import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Node> neighbors;
    private double betweennessCentrality;
    private int steps;

    public Node(String name) {

        this.name = name;
        this.neighbors = new ArrayList<>();
        this.betweennessCentrality = 0;
    }

    public void addBetweennessCentrality(double change) {
        betweennessCentrality += change;
    }
    public double getBetweennessCentrality() {
        return betweennessCentrality;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }
    public Node[] getNeighbors() {
        return neighbors.toArray(new Node[neighbors.size()]);
    }

    public int getSteps() {
        return steps;
    }
    public void addSteps(int change) {
        this.steps += change;
    }

    public String getName() {
        return name;
    }   
}
