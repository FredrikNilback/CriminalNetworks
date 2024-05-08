package Classes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PathFinder {

    public PathFinder() {
    }

    public void findPath(Node startNode, Node endNode, boolean betweeness) {

        if(betweeness) {
            determineClosetPaths(startNode, endNode);
        }
        else {
            determineSteps(startNode, endNode);
        }
    }

    public void focusOn(Node startNode, Node endNode, Node focusNode) {

        Queue<ArrayList<Node>> queue = new LinkedList<>();
        ArrayList<ArrayList<Node>> shortestPaths = new ArrayList<>();
        ArrayList<Node> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);

        int shortestPathLength = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            ArrayList<Node> currentPath = queue.poll();
            Node currentNode = currentPath.get(currentPath.size() - 1);
            if(currentNode == endNode && currentPath.size() <= shortestPathLength) {

                shortestPathLength = currentPath.size();
                shortestPaths.add(new ArrayList<>(currentPath));
            }

            if(currentPath.size() < shortestPathLength) {
                
                for(int i = 0; i < currentNode.getNeighbors().length; i++) {

                    Node neighbor = currentNode.getNeighbors()[i];
                    if(!currentPath.contains(neighbor)) {

                        ArrayList<Node> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        boolean found = false;
        for(int i = 0; i < shortestPaths.size(); i++) {

            ArrayList<Node> path = shortestPaths.get(i);
            if(path.contains(focusNode) && !path.get(0).equals(focusNode) && !path.get(path.size() - 1).equals(focusNode)) {
                found = true;
            }
        }
        
        if(found) {
            for(int i = 0; i < shortestPaths.size(); i++) {

                ArrayList<Node> path = shortestPaths.get(i);

                for (int j = 0; j < path.size() - 1; j++) {

                    if(path.get(j) == focusNode) {
                        System.out.print(path.get(j).getName() + " -> ");
                    }
                    else {
                        System.out.print(path.get(j).getName().toLowerCase() + " -> ");
                    }
                }
                System.out.print(path.get(path.size() - 1).getName().toLowerCase() + "\n");
            }
            System.out.println();
        }  
    }

    public void getPaths(Node startNode, Node endNode) {  

        Queue<ArrayList<Node>> queue = new LinkedList<>();
        ArrayList<ArrayList<Node>> shortestPaths = new ArrayList<>();
        ArrayList<Node> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);

        int shortestPathLength = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            ArrayList<Node> currentPath = queue.poll();
            Node currentNode = currentPath.get(currentPath.size() - 1);
            if(currentNode == endNode && currentPath.size() <= shortestPathLength) {

                shortestPathLength = currentPath.size();
                shortestPaths.add(new ArrayList<>(currentPath));
            }

            if(currentPath.size() < shortestPathLength) {
                
                for(int i = 0; i < currentNode.getNeighbors().length; i++) {

                    Node neighbor = currentNode.getNeighbors()[i];
                    if(!currentPath.contains(neighbor)) {

                        ArrayList<Node> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }
        for(int i = 0; i < shortestPaths.size(); i++) {
            for(int j = 0; j < shortestPaths.get(i).size() - 1; j++) {
                
                System.out.print(shortestPaths.get(i).get(j).getName() + " -> ");
            }
            System.out.print(shortestPaths.get(i).get(shortestPaths.get(i).size() - 1).getName() + "\n");
        }
    } 

    private void determineClosetPaths(Node startNode, Node endNode) {

        Queue<ArrayList<Node>> queue = new LinkedList<>();
        ArrayList<ArrayList<Node>> shortestPaths = new ArrayList<>();
        ArrayList<Node> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);

        int shortestPathLength = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            ArrayList<Node> currentPath = queue.poll();
            Node currentNode = currentPath.get(currentPath.size() - 1);
            if(currentNode == endNode && currentPath.size() <= shortestPathLength) {

                shortestPathLength = currentPath.size();
                shortestPaths.add(new ArrayList<>(currentPath));
            }

            if(currentPath.size() < shortestPathLength) {
                
                for(int i = 0; i < currentNode.getNeighbors().length; i++) {

                    Node neighbor = currentNode.getNeighbors()[i];
                    if(!currentPath.contains(neighbor)) {

                        ArrayList<Node> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        for(int i = 0; i < shortestPaths.size(); i++) {
            for(int j = 1; j < shortestPaths.get(i).size() - 1; j++) {
                
                Node node = shortestPaths.get(i).get(j);
                node.addBetweennessCentrality((double) 1 / shortestPaths.size());
            }
        }
    }

    private void determineSteps(Node startNode, Node endNode) {

        Queue<ArrayList<Node>> queue = new LinkedList<>();
        ArrayList<ArrayList<Node>> shortestPaths = new ArrayList<>();
        ArrayList<Node> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        queue.add(initialPath);

        int shortestPathLength = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            ArrayList<Node> currentPath = queue.poll();
            Node currentNode = currentPath.get(currentPath.size() - 1);
            if(currentNode == endNode && currentPath.size() <= shortestPathLength) {

                shortestPathLength = currentPath.size();
                shortestPaths.add(new ArrayList<>(currentPath));
            }

            if(currentPath.size() < shortestPathLength) {
                
                for(int i = 0; i < currentNode.getNeighbors().length; i++) {

                    Node neighbor = currentNode.getNeighbors()[i];
                    if(!currentPath.contains(neighbor)) {

                        ArrayList<Node> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        startNode.addSteps(shortestPathLength - 1);
    }
}
