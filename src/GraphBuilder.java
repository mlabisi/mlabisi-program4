import java.io.*;

/************************************************************
 * File:    GraphBuilder.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/21/17
 *
 * Description:
 * This class is the user interface for this program assignment.
 * It creates a Directed Graph based on the file input and allows
 * options to manipulate the graph and view the contents of the
 * vertices
 ************************************************************/
public class GraphBuilder {
    private static DictionaryInterface<Integer, City> cities = new Dictionary<>();

    private static WeightedGraphInterface<City> map = new DirectedGraph<>();

    private static void start() {
        fillCities();
    }

    private static void fillCities() {
        File inputFile = new File("city.dat");
        FileInputStream input = null;

        try {
            input = new FileInputStream(inputFile);
            String inputString = input.toString();
            String[] lines = inputString.split("\\r?\\n");

            int code, population, elevation;
            String id, name;

            for (String line : lines) {
                String[] info = line.split("\\s");
                code = Integer.parseInt(info[0]);
                id = info[1];
                name = info[2];
                population = Integer.parseInt(info[3]);
                elevation = Integer.parseInt(info[4]);

                cities.add(code, new City(id, name, population, elevation));
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
            exit();
        } catch (IOException e) {
            System.out.println("There was an error reading the file.");
            exit();
        }

    }

    private static void exit() {
        System.out.println("Bye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        start();
    }
}
