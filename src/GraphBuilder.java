import java.io.*;
import java.util.Scanner;

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

    /**
     * method:  start
     * purpose: runs the appropriate methods for the program
     */
    private static void start() {
        fillCities();
        makeMap();
    }

    /**
     * method:  fillCities
     * purpose: fills the static dictionary of cities with
     *          the data from the city.dat file
     */
    private static void fillCities() {
        File inputFile = new File("src/city.dat");
        Scanner input = null;

        try {
            input = new Scanner(inputFile);
            String inputString = input.nextLine();

            int code, population, elevation;
            String id, name;

            while(!inputString.isEmpty()) {
                String[] info = inputString.trim().split("\\s\\s+");
                code = Integer.parseInt(info[0]);
                id = info[1];
                name = info[2];
                population = Integer.parseInt(info[3]);
                elevation = Integer.parseInt(info[4]);

                cities.add(code, new City(id, name, population, elevation));

                inputString = input.nextLine();
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
            exit();
        }

    }

    /**
     * method:  makeMap
     * purpose: creates our graph with the data from
     *          the road.dat file
     */
    private static void makeMap(){

    }

    /**
     * method:  exit
     * purpose: exits the program
     */
    private static void exit() {
        System.out.println("Bye!");
        System.exit(0);
    }

    // M A I N   M E T H O D

    /**
     * method:  main
     * purpose: this is the main method
     */
    public static void main(String[] args) {
        start();
    }
}
