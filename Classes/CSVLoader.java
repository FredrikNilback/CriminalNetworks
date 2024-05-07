package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVLoader {

    private String path;

    public CSVLoader(int csvNumber) {
        path = "CSVs/Network" + csvNumber + ".csv";
    }

    public void setCSVNumber(int csvNumber) {
        path = "CSVs/Network" + csvNumber + ".csv";
    }

    public Node[] run() {

        String line = "";
        ArrayList<Node> nodes = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while((line = bufferedReader.readLine()) != null) {

                String nodeName = line.split(",")[0];
                nodes.add(new Node(nodeName));
            }
        } 
        catch(IOException e) {
            System.out.println("Something went wrong");
        }

        line = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] data = line.split(",");
                Node node = nodes.get(index);

                for (int i = 1; i < data.length; i++) {
                    Node neighborNode = nodes.get(StaticAlphabet.getLetterIndex(data[i]));
                    node.addNeighbor(neighborNode);
                }
                index++;
            }

            return nodes.toArray(new Node[nodes.size()]);
        } 
        catch (IOException e) {
            System.out.println("Something went wrong");
        }

        return new Node[0];
    }
}
