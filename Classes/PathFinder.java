package Classes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PathFinder {

    private Node[] nodes;

    public PathFinder(Node[] nodes) {
        this.nodes = nodes; 
    }

    public void findPath(String startNodeString, String endNodeString) {

        Node startNode = nodes[StaticAlphabet.getLetterIndex(startNodeString)];
        Node endNode = nodes[StaticAlphabet.getLetterIndex(endNodeString)];

        determineClosetPaths(startNode, endNode);
        //assingWeights();
    }

    private void determineClosetPaths(Node startNode, Node endNode) {

        Queue<ArrayList<Node>> queue = new LinkedList<>();
        ArrayList<ArrayList<Node>> shortestPaths = new ArrayList<>();
        ArrayList<Node> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);

        int shortestPathLength = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            ArrayList<Node> currentPath = queue.poll();
            Node currentNode = currentPath.get(currentPath.size() - 1);

            if (currentNode == endNode && currentPath.size() <= shortestPathLength) {
                shortestPathLength = currentPath.size();
                shortestPaths.add(new ArrayList<>(currentPath));
            }

            if(currentPath.size() < shortestPathLength) {
                
                for(int i = 0; i < currentNode.getNeighbors().length; i++) {

                    Node neighbor = currentNode.getNeighbors()[i];
                    if (!currentPath.contains(neighbor)) {

                        ArrayList<Node> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        // Temporary sout shortest paths
        for (int i = 0; i < shortestPaths.size(); i++) {

            ArrayList<Node> path = shortestPaths.get(i);

            for (int j = 0; j < path.size() - 1; j++) {
                System.out.print(path.get(j).getName() + " -> ");
            }
            System.out.print(path.get(path.size() - 1).getName() + "\n");
            
        }
    }
}
