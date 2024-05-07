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

                String[] data = line.split(",");
                nodes.add(new Node(data[0]));
            }
        } 
        catch(IOException e) {
            System.out.println("Something went wrong");
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                
                
                
            }

            return nodes.toArray(new Node[nodes.size()]);
        } 
        catch (IOException e) {
            System.out.println("Something went wrong");
        }

        return new Node[0];

    }
}
