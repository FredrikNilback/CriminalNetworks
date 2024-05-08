package Classes;

public class Container {

    private Node[] network;
    private PathFinder pathFinder;

    public Container(Node[] network) {

        this.network = network;
        this.pathFinder = new PathFinder();
    }

    public void getBetweennessCentralities() {

        for(int i = 0; i < network.length - 1; i++) {
            for(int j = i + 1; j < network.length; j++) {
                pathFinder.findPath(network[i], network[j], true);
           } 
        }

        for (int i = 0; i < network.length; i++) {
            double roundedWeight = Math.round(network[i].getBetweennessCentrality() * 100.0) / 100.0; 
            System.out.println(network[i].getName() + ": " + roundedWeight);
        }
    }

    public void focusOn(String nodeFocus) {

        Node focusNode = network[StaticAlphabet.getLetterIndex(nodeFocus)];
        for(int i = 0; i < network.length - 1; i++) {
            for(int j = i + 1; j < network.length; j++) {
                pathFinder.focusOn(network[i], network[j], focusNode);
           } 
        }
    }

    public void getPaths(String nodeNameStart, String nodeNameEnd) {

        int nodeIndexStart = StaticAlphabet.getLetterIndex(nodeNameStart);
        int nodeIndexEnd = StaticAlphabet.getLetterIndex(nodeNameEnd);
        Node nodeStart = network[nodeIndexStart];
        Node nodeEnd = network[nodeIndexEnd];

        pathFinder.getPaths(nodeStart, nodeEnd);
    }
    
    public void getSteps(String nodeName) {

        int nodeIndex = StaticAlphabet.getLetterIndex(nodeName);
        Node node = network[nodeIndex];

        for(int i = 0; i < network.length; i++) {
            if(i == nodeIndex) {
                continue;
            }
            pathFinder.findPath(node, network[i], false);
        }
        System.out.println(nodeName + " Steps: " + node.getSteps());
        System.out.println(nodeName + " Closeness Centrality: " + (double) (network.length - 1) / node.getSteps());
        System.out.println(nodeName + " Degree Centrality: " + (double) node.getNeighbors().length / (network.length - 1));
    }

    @Deprecated
    public void printInfo() {

        for(int i = 0; i < network.length; i++) {

            System.out.print(network[i].getName() + ": ");
            Node[] neighbors = network[i].getNeighbors();

            for (int j = 0; j < neighbors.length - 1; j++) {
                System.out.print(neighbors[j].getName() + ", ");
            }
            System.out.print(neighbors[neighbors.length - 1].getName() + "\n");
        }
    }
}
