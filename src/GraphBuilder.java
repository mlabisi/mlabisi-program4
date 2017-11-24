import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    private static ArrayList<City> cities = new ArrayList<>(20);

    private static WeightedGraphInterface<City> map = new DirectedGraph<>();

    /**
     * method:  start
     * purpose: runs the appropriate methods for the program
     */
    private static void start() {
        fillCities();
        makeMap();
        helpMenu();
        run();
    }

    /**
     * method:  helpMenu
     * purpose: displays the help menu with the features of this program
     */
    private static void helpMenu() {
        System.out.println("-----HELP MENU-----\n"
                + " Q - Query the city information by entering the city code\n"
                + " D - Find the minimum distance between two cities\n"
                + " I - Insert a road by entering two city codes and distance\n"
                + " R - Remove an existing road by entering two city codes\n"
                //+ " M - Display the map's roads\n"
                + " C - Display all of the map's cities and their data\n"
                + " H - display this menu\n"
                + " E - exit the program");
    } // end helpMenu

    /**
     * method:  run
     * purpose: this loop, whose actions are based on user input,
     * will run until the user enters the command to
     * exit the program
     */
    private static void run() {
        boolean running = true;

        while (running) {
            String answer = getUserInput().toUpperCase();

            try {
                switch (answer) {
                    case "Q":
                        query();
                        break;
                    case "D":
                        findDistance();
                        break;
                    case "I":
                        insert();
                        break;
                    case "R":
                        removeRoad();
                        break;
                    case "M":
                        break;
                    case "C":
                        System.out.println(cities);
                        break;
                    case "H":
                        helpMenu();
                        break;
                    case "E":
                        running = false;
                        break;
                    default:
                        System.out.println("Sorry, your command did not work. Please try again (type 'H' for help).");
                }
            } catch (NumberFormatException e) {
                System.out.println("There was an error processing your command. Please try again.");
                run();
            }
        }
        exit();
    }

    /**
     * method:  getUserInput
     * purpose: display a '>' to prompt user input, then retrieve the input
     *
     * @return the user input
     */
    private static String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        return in.nextLine();
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


                cities.add(new City(code, id, name, population, elevation));
                map.addVertex(cities.get(cities.size() - 1));

                inputString = input.nextLine();
            }
            // FOR TESTING
            //System.out.println(cities);

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
        File inputFile = new File("src/road.dat");
        Scanner input = null;

        try {
            input = new Scanner(inputFile);
            String inputString = input.nextLine();

            while(input.hasNext()) {
                String[] info = inputString.trim().split("\\s\\s+");
                map.addEdge(cities.get(Integer.parseInt(info[0]) - 1),
                        cities.get(Integer.parseInt(info[1]) - 1),
                        Integer.parseInt(info[2]));

                // FOR TESTING
//                System.out.println(cities.get(Integer.parseInt(info[0]) - 1).getNAME() +
//                        " --> " +
//                        cities.get(Integer.parseInt(info[1]) - 1).getNAME() +
//                        " (" + Integer.parseInt(info[2]) + ")");
                inputString = input.nextLine();
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!");
            exit();
        }
    }

    /**
     * method:  query
     * purpose: queries the given city's information
     */
    private static void query(){
        System.out.println("Please enter the city ID.");
        String id = null;

        try {
            id = getUserInput();
            String info = ((DirectedGraph<City>)map).displayVertex(findCity(id.trim()));
            System.out.print(info);
        } catch(NullPointerException e){
            System.out.println("That city ID was not recognized!");
            helpMenu();
        } catch (InputMismatchException e){
            System.out.println("There was an error with your input.");
            helpMenu();
        }
    }

    /**
     * method:  insert
     * purpose: inserts a road/edge between two given cities
     */
    private static void insert(){
        System.out.println("Please enter the city IDs separated by a space.");
        String input = null;
        int distance = 0;

        try {
            input = getUserInput();

            System.out.println("Please enter the distance between the cities.");
            distance = Integer.parseInt(getUserInput());

            String[] cities = input.split("\\s");
            City city1 = findCity(cities[0]);
            City city2 = findCity(cities[1]);

            map.addEdge(city1, city2, distance);
            System.out.println(city1.getNAME() +
                        " --> " +
                        city2.getNAME() +
                        " (" + distance + ")");
        } catch(NullPointerException e){
            System.out.println("One or both of your city IDs were not recognized!");
            helpMenu();
        } catch (InputMismatchException e){
            System.out.println("There was an error with your input.");
            helpMenu();
        }
    }

    /**
     * method:  findDistance
     * purpose: finds the minimum distance between two cities
     */
    private static void findDistance(){

    }

    /**
     * method:  removeRoad
     * purpose: removes an existing road
     */
    private static void removeRoad(){

    }

    /**
     * method:  findCity
     * purpose: this helper method will find the city
     *          whose ID matches the given data
     *
     * @param id    the ID of the city
     * @return  the city or null if not found
     */
    private static City findCity(String id){
        City found = null;
        for(City city : cities){
            if((city.getID()).equalsIgnoreCase(id)){
                found = city;
            }
        }

        return found;
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
