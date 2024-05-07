package Classes;

public class Container {

    private Node[] network;

    public Container(Node[] network) {

        this.network = network;
    }

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
