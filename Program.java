import Classes.CSVLoader;
import Classes.Container;
import Classes.Node;

public class Program {
    public Program() {

        CSVLoader loader = new CSVLoader(1);
        Node[] network = loader.run();
        Container container = new Container(network);
        container.printInfo();
    }
}
