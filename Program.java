import java.util.Scanner;

import Classes.CSVLoader;
import Classes.Container;
import Classes.Node;

public class Program {
    public Program(String networkIndex, String mode) {

        CSVLoader loader = new CSVLoader(Integer.parseInt(networkIndex));
        Node[] network = loader.run();
        Container container = new Container(network);
        Scanner scanner;
        String startNode;

        switch(mode) {

            case "bc":
                container.getBetweennessCentralities();
                break;
            case "path":
                scanner = new Scanner(System.in);
                System.out.println("Enter Start Node: ");
                startNode = scanner.nextLine().toUpperCase();
                System.out.println("Enter End Node: ");
                String endNode = scanner.nextLine();
                container.getPaths(startNode, endNode);
                break;
            case "steps":
                scanner = new Scanner(System.in);
                System.out.println("Enter Node: ");
                startNode = scanner.nextLine().toUpperCase();
                container.getSteps(startNode);
                break;
            case "focus":
                scanner = new Scanner(System.in);
                System.out.println("Enter Node: ");
                String focusNode = scanner.nextLine().toUpperCase();
                container.focusOn(focusNode);
                break;

            default:
                break;
        }
    }
}
